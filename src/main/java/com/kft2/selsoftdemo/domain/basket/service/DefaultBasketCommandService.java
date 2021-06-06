package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.domain.account.service.AccountQueryService;
import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.repository.BasketItemRepository;
import com.kft2.selsoftdemo.domain.basket.repository.BasketRepository;
import com.kft2.selsoftdemo.domain.cafe.service.ProductQueryService;
import com.kft2.selsoftdemo.infrastructure.selsoftpayment.SelsoftPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class DefaultBasketCommandService implements BasketCommandService {

    private final BasketQueryService basketQueryService;
    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;
    private final ProductQueryService productQueryService;
    private final AccountQueryService accountQueryService;
    private final SelsoftPaymentService selsoftPaymentService;


    @Transactional
    @Override
    public void addItemToBasket(HttpServletRequest httpServletRequest, AddItemToBasketRequest addItemToBasketRequest) {

        var basket = basketQueryService.getBasketByToken(httpServletRequest);
        var product = productQueryService.findById(addItemToBasketRequest.getProductId());
        var basketItem = basketItemRepository.findByBasketIdAndProductId(basket.getId(), product.getId());

        basketItem.updateQuantityAndPrice(addItemToBasketRequest.getQuantity(), product.getPrice());
        basketItemRepository.save(basketItem);
        updateTotalBasketPrice(basket.getId());
    }

    @Override
    public void remoteItemFromBasket(HttpServletRequest httpServletRequest, Long id) {

        var basketItem = basketItemRepository.findById(id);
        basketItemRepository.remove(basketItem);
        var basket = basketQueryService.getBasketByToken(httpServletRequest);
        updateTotalBasketPrice(basket.getId());

    }


    private void updateTotalBasketPrice(Long basketId) {

    }

    @Override
    public void orderBasket(HttpServletRequest httpServletRequest) {
        var account = accountQueryService.getIdentityFromToken(httpServletRequest);
        var basket = basketRepository.findByAccountId(account.getId());
        selsoftPaymentService.order(account.getEmail(), basket.getTotalPrice());
    }


}
