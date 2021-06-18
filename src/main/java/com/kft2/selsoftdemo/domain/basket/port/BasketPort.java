package com.kft2.selsoftdemo.domain.basket.port;

import com.kft2.selsoftdemo.domain.basket.model.Basket;

public interface BasketPort {

    Basket findByAccountId(Long accountId);

    Basket findById(Long id);

    void save(Basket basket);

}
