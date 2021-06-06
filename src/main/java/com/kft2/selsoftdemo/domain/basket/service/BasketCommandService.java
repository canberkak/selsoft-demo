package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;

import javax.servlet.http.HttpServletRequest;

public interface BasketCommandService {

    void addItemToBasket(HttpServletRequest httpServletRequest, AddItemToBasketRequest addItemToBasketRequest);

    void orderBasket(HttpServletRequest httpServletRequest);

}
