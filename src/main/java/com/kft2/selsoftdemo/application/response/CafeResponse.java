package com.kft2.selsoftdemo.application.response;

import com.kft2.selsoftdemo.domain.cafe.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CafeResponse {

    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private List<Product> productList;

}
