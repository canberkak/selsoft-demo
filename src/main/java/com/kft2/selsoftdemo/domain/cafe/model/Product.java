package com.kft2.selsoftdemo.domain.cafe.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {

    private Long id;
    private String name;
    private String details;
    private BigDecimal price;
    private Long caffeId;

}
