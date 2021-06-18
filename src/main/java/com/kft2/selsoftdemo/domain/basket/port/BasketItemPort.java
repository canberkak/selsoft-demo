package com.kft2.selsoftdemo.domain.basket.port;

import com.kft2.selsoftdemo.domain.basket.model.BasketItem;

import java.util.List;

public interface BasketItemPort {

    BasketItem findByBasketIdAndProductId(Long basketId, Long productId);

    List<BasketItem> findByBasketId(Long basketId);

    BasketItem findById(Long basketItemId);

    void save(BasketItem basketItem);

    void remove(BasketItem basketItem);
}
