package com.teksystems.domain.dto;

import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.good.Apples;
import com.teksystems.domain.models.good.Bread;
import com.teksystems.domain.models.good.Milk;
import com.teksystems.domain.models.good.Soup;
import com.teksystems.domain.models.good.base.Good;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CalculateDTO {

    private Long applesCount;
    private Long breadCount;
    private Long milkCount;
    private Long soupCount;
    private BigDecimal applesPrice;
    private BigDecimal breadPrice;
    private BigDecimal milkPrice;
    private BigDecimal soupPrice;

    public static CalculateDTO generateDTO(List<Good> goodList) {
        return CalculateDTO.builder()
                .applesCount(getNumberOfGood(goodList, GoodType.APPLES))
                .breadCount(getNumberOfGood(goodList, GoodType.BREAD))
                .milkCount(getNumberOfGood(goodList, GoodType.MILK))
                .soupCount(getNumberOfGood(goodList, GoodType.SOUP))
                .applesPrice(new Apples().getPrice())
                .breadPrice(new Bread().getPrice())
                .milkPrice(new Milk().getPrice())
                .soupPrice(new Soup().getPrice())
                .build();
    }

    public static Long getNumberOfGood(List<Good> goodList, GoodType goodType) {

        return goodList.stream()
                .filter((g) -> goodType.equals(g.getGoodType()))
                .count();
    }

    public static BigDecimal getGoodPrice(GoodType goodType) {

        BigDecimal price;

        switch (goodType) {
            case MILK:
                price = new Milk().getPrice();
                break;
            case APPLES:
                price = new Apples().getPrice();
                break;
            case BREAD:
                price = new Bread().getPrice();
                break;
            case SOUP:
                price = new Soup().getPrice();
                break;
            default:
                price = BigDecimal.ZERO;
        }
        return price;

    }

    public static Good convertStringToGood(String goodText) {

        if (goodText.equalsIgnoreCase("Bread")) {
            return new Bread();
        } else if (goodText.equalsIgnoreCase(("Apples"))) {
            return new Apples();
        } else if (goodText.equalsIgnoreCase(("Milk"))) {
            return new Milk();
        } else if (goodText.equalsIgnoreCase(("Soup"))) {
            return new Soup();
        }
        return null;

    }


}
