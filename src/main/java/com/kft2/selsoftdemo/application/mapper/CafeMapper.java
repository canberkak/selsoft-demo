package com.kft2.selsoftdemo.application.mapper;

import com.kft2.selsoftdemo.application.response.CafeResponse;
import com.kft2.selsoftdemo.domain.cafe.model.Cafe;

import java.util.List;

public interface CafeMapper {

    CafeResponse cafeToCafeResponse(Cafe cafe);

    List<CafeResponse> cafeListToCafeResponseList(List<Cafe> cafeList);
}
