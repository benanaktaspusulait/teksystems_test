package com.teksystems.service;

import com.teksystems.dataseeder.OfferSeeder;
import com.teksystems.domain.dto.CalculateDTO;
import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.good.base.Good;
import com.teksystems.domain.models.offer.Offer;
import com.teksystems.util.DateUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

public class CalculateService {

    public static String calculate(CalculateDTO dto, List<Good> goodList, Integer day) throws ScriptException, NoSuchMethodException {

        BigDecimal totalAmount = BigDecimal.ZERO;
        BigDecimal totalDiscountAmount = BigDecimal.ZERO;
        List<Offer> offerList = OfferSeeder.createOffers();
        StringBuffer totalText = new StringBuffer();
        Date date = DateUtils.ndaysAfter(day);
        for (GoodType goodType : GoodType.values()) {

            Long numberOfGood = CalculateDTO.getNumberOfGood(goodList, goodType);
            Offer offer = OfferService.findOffer(offerList, goodType, date);
            BigDecimal discountAmount = BigDecimal.ZERO;
            if (offer != null && numberOfGood > 0) {
                ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
                Invocable invocable = (Invocable) nashorn;
                nashorn.eval(offer.getOfferFunction());
                discountAmount = new BigDecimal(invocable.invokeFunction(offer.getName(), dto).toString()).
                        setScale(2, RoundingMode.CEILING);
                if (discountAmount.compareTo(BigDecimal.ZERO) == 1) {
                    totalDiscountAmount = totalDiscountAmount.add(discountAmount);
                }
            }
            totalAmount = totalAmount.add(CalculateDTO.getGoodPrice(goodType).multiply(new BigDecimal(numberOfGood)));
        }
        totalAmount = totalAmount.subtract(totalDiscountAmount);
        totalText.append("Expected total cost = ").append(totalAmount).append(";");

        return totalText.toString();
    }

}
