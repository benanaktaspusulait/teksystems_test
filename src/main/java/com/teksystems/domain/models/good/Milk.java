package com.teksystems.domain.models.good;

import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.enums.UnitType;
import com.teksystems.domain.models.good.base.Good;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Milk extends Good {

    public Milk() {
        setGoodType(GoodType.MILK);
        setUnitType(UnitType.BOTTLE);
        setPrice(new BigDecimal("1.30"));
    }

}
