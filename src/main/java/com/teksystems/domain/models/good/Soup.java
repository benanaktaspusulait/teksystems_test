package com.teksystems.domain.models.good;

import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.enums.UnitType;
import com.teksystems.domain.models.good.base.Good;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Soup extends Good {

    public Soup() {
        setGoodType(GoodType.SOUP);
        setUnitType(UnitType.TIN);
        setPrice(new BigDecimal("0.65"));
    }
}
