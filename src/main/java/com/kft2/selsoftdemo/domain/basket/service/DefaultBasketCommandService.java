package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.domain.account.service.AccountQueryService;
import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.port.BasketItemPort;
import com.kft2.selsoftdemo.domain.basket.port.BasketPort;
import com.kft2.selsoftdemo.domain.cafe.service.ProductQueryService;
import com.kft2.selsoftdemo.infrastructure.selsoftpayment.SelsoftPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class DefaultBasketCommandService implements BasketCommandService {

    private final BasketQueryService basketQueryService;
    private final BasketPort basketPort;
    private final BasketItemPort basketItemPort;
    private final ProductQueryService productQueryService;
    private final AccountQueryService accountQueryService;
    private final SelsoftPaymentService selsoftPaymentService;


    @Transactional
    @Override
    public void addItemToBasket(Basket basket, AddItemToBasketRequest addItemToBasketRequest) {
        var product = productQueryService.findById(addItemToBasketRequest.getProductId());
        var basketItem = basketItemPort.findByBasketIdAndProductId(basket.getId(), product.getId());

        basketItem.updateQuantityAndPrice(addItemToBasketRequest.getQuantity(), product.getPrice());
        basketItemPort.save(basketItem);
        basket.addBasketItem(basketItem);
        updateTotalBasketPrice(basket);
    }

    @Override
    public void removeItemFromBasket(Basket basket, Long id) {
        var basketItem = basketItemPort.findById(id);

        basketItemPort.remove(basketItem);
        basket.removeBasketItem(basketItem);
        updateTotalBasketPrice(basket);

    }

    private void updateTotalBasketPrice(Basket basket) {
        basket.updateTotalPrice();
        basketPort.save(basket);
    }

    @Override
    public void orderBasket(Long accountId) {
        var account = accountQueryService.findById(accountId);
        var basket = basketPort.findByAccountId(account.getId());

        selsoftPaymentService.order(account.getEmail(), basket.getTotalPrice());
        basket.complete();
        basketPort.save(basket);
    }


}
