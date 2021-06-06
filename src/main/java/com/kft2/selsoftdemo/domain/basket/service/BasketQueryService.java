package com.kft2.selsoftdemo.domain.basket.service;


import com.kft2.selsoftdemo.domain.basket.model.Basket;

import javax.servlet.http.HttpServletRequest;

public interface BasketQueryService {

    Basket getBasketByToken(HttpServletRequest httpServletRequest);
}
