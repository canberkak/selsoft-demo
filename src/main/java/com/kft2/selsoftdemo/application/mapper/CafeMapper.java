package com.kft2.selsoftdemo.application.mapper;

import com.kft2.selsoftdemo.application.response.CafeResponse;
import com.kft2.selsoftdemo.domain.cafe.model.Cafe;

import java.util.List;
import java.util.stream.Collectors;

public class CafeMapper {

    public static CafeResponse cafeToCafeResponse(Cafe cafe) {
        return CafeResponse.builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .address(cafe.getAddress())
                .phoneNumber(cafe.getPhoneNumber())
                .productList(cafe.getProductList())
                .build();
    }

    public static List<CafeResponse> cafeListToCafeResponseList(List<Cafe> cafeList) {
        return cafeList.stream().map(CafeMapper::cafeToCafeResponse).collect(Collectors.toList());
    }
}
