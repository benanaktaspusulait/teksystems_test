package com.teksystems.domain.models.offer;

import com.teksystems.domain.models.enums.GoodType;
import lombok.Data;

import java.util.Date;

@Data
public class Offer {

    private Long id;
    private String name;
    private String description;
    private GoodType goodType;
    private String offerFunction;
    private Date validStartDate;
    private Date validEndDate;
}
