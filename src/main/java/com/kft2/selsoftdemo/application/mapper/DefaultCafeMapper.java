package com.kft2.selsoftdemo.application.mapper;

import com.kft2.selsoftdemo.application.response.CafeResponse;
import com.kft2.selsoftdemo.domain.cafe.model.Cafe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCafeMapper implements CafeMapper {

    @Override
    public CafeResponse cafeToCafeResponse(Cafe cafe) {
        return CafeResponse.builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .address(cafe.getAddress())
                .phoneNumber(cafe.getPhoneNumber())
                .productList(cafe.getProductList())
                .build();
    }

    @Override
    public List<CafeResponse> cafeListToCafeResponseList(List<Cafe> cafeList) {
        return cafeList.stream().map(this::cafeToCafeResponse).collect(Collectors.toList());
    }
}
