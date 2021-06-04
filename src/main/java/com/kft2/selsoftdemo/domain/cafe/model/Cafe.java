package com.kft2.selsoftdemo.domain.cafe.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Cafe {

    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private List<Product> productList;
}
