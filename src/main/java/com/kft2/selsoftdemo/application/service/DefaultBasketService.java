package com.kft2.selsoftdemo.application.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.service.BasketCommandService;
import com.kft2.selsoftdemo.domain.basket.service.BasketQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class DefaultBasketService implements BasketService {

    private final BasketCommandService basketCommandService;
    private final BasketQueryService basketQueryService;
    private final AccountService accountService;

    @Override
    public void addItemToBasket(HttpServletRequest httpServletRequest, AddItemToBasketRequest addItemToBasketRequest) {
        var basket = getBasketByToken(httpServletRequest);
        basketCommandService.addItemToBasket(basket, addItemToBasketRequest);


    }

    @Override
    public void orderBasket(HttpServletRequest httpServletRequest) {
        var account = accountService.getIdentityFromToken(httpServletRequest);
        basketCommandService.orderBasket(account.getId());
    }

    @Override
    public void removeItemFromBasket(HttpServletRequest httpServletRequest, Long id) {
        var basket = getBasketByToken(httpServletRequest);
        basketCommandService.removeItemFromBasket(basket, id);

    }

    @Override
    public Basket getBasketByToken(HttpServletRequest httpServletRequest) {
        var account = accountService.getIdentityFromToken(httpServletRequest);
        return basketQueryService.getBasketByAccountId(account.getId());
    }
}
