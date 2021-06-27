package com.kft2.selsoftdemo.application.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.domain.basket.model.Basket;

import javax.servlet.http.HttpServletRequest;

public interface BasketService {

    void addItemToBasket(HttpServletRequest httpServletRequest, AddItemToBasketRequest addItemToBasketRequest);

    void orderBasket(HttpServletRequest httpServletRequest);

    void removeItemFromBasket(HttpServletRequest httpServletRequest, Long id);

    Basket getBasketByToken(HttpServletRequest httpServletRequest);

}
