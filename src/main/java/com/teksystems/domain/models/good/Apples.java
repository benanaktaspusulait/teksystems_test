package com.teksystems.domain.models.good;

import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.enums.UnitType;
import com.teksystems.domain.models.good.base.Good;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Apples extends Good {

    public Apples() {
        setGoodType(GoodType.APPLES);
        setUnitType(UnitType.SINGLE);
        setPrice(new BigDecimal("0.10"));
    }

}
