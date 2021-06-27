package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.domain.basket.model.Basket;


public interface BasketCommandService {

    void addItemToBasket(Basket basket, AddItemToBasketRequest addItemToBasketRequest);

    void orderBasket(Long accountId);

    void removeItemFromBasket(Basket basket, Long id);
}
