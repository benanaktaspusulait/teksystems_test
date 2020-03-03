package com.teksystems.domain.models.good.base;

import com.teksystems.domain.models.enums.GoodType;
import com.teksystems.domain.models.enums.UnitType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class Good {

    private Long id;
    private String name;
    private UnitType unitType;
    private BigDecimal price;
    private GoodType goodType;
}
