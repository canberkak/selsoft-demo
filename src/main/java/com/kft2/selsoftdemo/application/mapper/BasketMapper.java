package com.kft2.selsoftdemo.application.mapper;

import com.kft2.selsoftdemo.application.response.BasketResponse;
import com.kft2.selsoftdemo.domain.basket.model.Basket;

public class BasketMapper {

    public static BasketResponse basketToBasketResponse(Basket basket) {
        return BasketResponse.builder()
                .id(basket.getId())
                .totalPrice(basket.getTotalPrice())
                .basketItemList(basket.getBasketItemList())
                .build();
    }
}
