package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;

public interface BasketCommandService {

    void addItemToBasket(AddItemToBasketRequest addItemToBasketRequest);

}
