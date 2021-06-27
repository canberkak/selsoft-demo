package com.kft2.selsoftdemo.domain.basket.service;


import com.kft2.selsoftdemo.domain.basket.model.Basket;

public interface BasketQueryService {

    Basket getBasketByAccountId(Long id);
}
