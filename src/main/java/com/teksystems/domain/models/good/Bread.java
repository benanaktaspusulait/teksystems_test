package com.teksystems.domain.models.good;

import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.enums.UnitType;
import com.teksystems.domain.models.good.base.Good;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bread extends Good {

    public Bread() {
        setGoodType(GoodType.BREAD);
        setUnitType(UnitType.LOAF);
        setPrice(new BigDecimal("0.80"));

    }
}
