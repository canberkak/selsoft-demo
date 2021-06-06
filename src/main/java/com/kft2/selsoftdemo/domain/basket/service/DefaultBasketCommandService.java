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

    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;
    private final ProductQueryService productQueryService;
    private final AccountQueryService accountQueryService;
    private final SelsoftPaymentService selsoftPaymentService;


    @Transactional
    @Override
    public void addItemToBasket(HttpServletRequest httpServletRequest, AddItemToBasketRequest addItemToBasketRequest) {

        var basket = getBasketByToken(httpServletRequest);
        var product = productQueryService.findById(addItemToBasketRequest.getProductId());
        var basketItem = basketItemRepository.findByBasketIdAndProductId(basket.getId(), product.getId());

        basketItem.updateQuantityAndPrice(addItemToBasketRequest.getQuantity(), product.getPrice());
        basketItemRepository.save(basketItem);
        //updateTotalBasketPrice(basket);
    }

    private Basket getBasketByToken(HttpServletRequest httpServletRequest) {
        var account = accountQueryService.getIdentityFromToken(httpServletRequest);
        return basketRepository.findByAccountId(account.getId());
    }

    /*
    private void updateTotalBasketPrice(Basket basket) {
        var basketItemList = basketItemRepository.findByBasketId(basket.getId());
        basket.setTotalPrice(basketItemList);
        basketRepository.save(basket);

    }
     */

    @Override
    public void orderBasket(HttpServletRequest httpServletRequest) {
        var account = accountQueryService.getIdentityFromToken(httpServletRequest);
        var basket = basketRepository.findByAccountId(account.getId());
        selsoftPaymentService.order(account.getEmail(), basket.getTotalPrice());
    }

}
