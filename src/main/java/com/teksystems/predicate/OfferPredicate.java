package com.teksystems.predicate;


import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.good.base.Good;
import com.teksystems.domain.models.offer.Offer;

import java.util.Date;
import java.util.function.Predicate;

public class OfferPredicate {

    public static Predicate<Offer> filterByDate(Date date) {
        return pr -> (pr.getValidStartDate().before(date) &&
                pr.getValidEndDate().after(date));
    }

    public static Predicate<Offer> filterByGoodType(GoodType goodType) {
        return pr -> (pr.getGoodType().equals(goodType));
    }

}
