package com.teksystems.dataseeder;

import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.offer.Offer;
import com.teksystems.util.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class OfferSeeder {

    public static List<Offer> createOffers() {

        List<Offer> offerList = new ArrayList<>();

        Offer appleOffer = new Offer();
        appleOffer.setId(1L);
        appleOffer.setName("appleOffer");
        appleOffer.setDescription("Apples 10% off: ");
        appleOffer.setOfferFunction("function appleOffer(x) { return  x.applesCount * ((x.applesPrice * 10)/100);}");
        appleOffer.setGoodType(GoodType.APPLES);
        appleOffer.setValidStartDate(DateUtils.ndaysAfter(3));
        appleOffer.setValidEndDate(DateUtils.getEndOfMonth());

        offerList.add(appleOffer);

        Offer breadOffer = new Offer();
        breadOffer.setId(2L);
        breadOffer.setName("breadOffer");
        breadOffer.setDescription("Bread half price: ");
        breadOffer.setOfferFunction("function breadOffer(x) {if (x.soupCount >= 2){ return  Math.floor(x.soupCount / 2 ) * (x.breadPrice / 2);} return 0;}");
        breadOffer.setGoodType(GoodType.BREAD);
        breadOffer.setValidStartDate(DateUtils.ndaysAfter(-1));
        breadOffer.setValidEndDate(DateUtils.ndaysAfter(7));
        offerList.add(breadOffer);

        return offerList;
    }
}
