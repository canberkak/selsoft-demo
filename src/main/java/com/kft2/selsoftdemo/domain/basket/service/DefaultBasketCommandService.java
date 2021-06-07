package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.domain.account.service.AccountQueryService;
import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.repository.BasketItemAdapter;
import com.kft2.selsoftdemo.domain.basket.repository.BasketAdapter;
import com.kft2.selsoftdemo.domain.cafe.service.ProductQueryService;
import com.kft2.selsoftdemo.infrastructure.selsoftpayment.SelsoftPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class DefaultBasketCommandService implements BasketCommandService {

    private final BasketQueryService basketQueryService;
    private final BasketAdapter basketAdapter;
    private final BasketItemAdapter basketItemAdapter;
    private final ProductQueryService productQueryService;
    private final AccountQueryService accountQueryService;
    private final SelsoftPaymentService selsoftPaymentService;


    @Transactional
    @Override
    public void addItemToBasket(HttpServletRequest httpServletRequest, AddItemToBasketRequest addItemToBasketRequest) {

        var basket = basketQueryService.getBasketByToken(httpServletRequest);
        var product = productQueryService.findById(addItemToBasketRequest.getProductId());
        var basketItem = basketItemAdapter.findByBasketIdAndProductId(basket.getId(), product.getId());

        basketItem.updateQuantityAndPrice(addItemToBasketRequest.getQuantity(), product.getPrice());
        basketItemAdapter.save(basketItem);
        basket.addBasketItem(basketItem);
        updateTotalBasketPrice(basket);
    }

    @Override
    public void removeItemFromBasket(HttpServletRequest httpServletRequest, Long id) {

        var basket = basketQueryService.getBasketByToken(httpServletRequest);
        var basketItem = basketItemAdapter.findById(id);

        basketItemAdapter.remove(basketItem);
        basket.removeBasketItem(basketItem);
        updateTotalBasketPrice(basket);

    }

    private void updateTotalBasketPrice(Basket basket) {
        basket.updateTotalPrice();
        basketAdapter.save(basket);
    }

    @Override
    public void orderBasket(HttpServletRequest httpServletRequest) {

        var account = accountQueryService.getIdentityFromToken(httpServletRequest);
        var basket = basketAdapter.findByAccountId(account.getId());

        selsoftPaymentService.order(account.getEmail(), basket.getTotalPrice());
        basket.complete();
        basketAdapter.save(basket);
    }


}
