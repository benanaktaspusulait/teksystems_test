package com.teksystems.service;

import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.offer.Offer;
import com.teksystems.predicate.OfferPredicate;

import java.util.Date;
import java.util.List;

public class OfferService {

    public static Offer findOffer(List<Offer> offerList, GoodType goodType, Date date) {

        return offerList.stream()
                .filter(OfferPredicate.filterByDate(date))
                .filter(OfferPredicate.filterByGoodType(goodType))
                .findAny()
                .orElse(null);

    }
}
