package com.kft2.selsoftdemo.domain.basket.repository;

import com.kft2.selsoftdemo.domain.basket.model.Basket;

public interface BasketRepository {

    Basket findByAccountId(Long accountId);

    Basket findById(Long id);

    void save(Basket basket);

}
