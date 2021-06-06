package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.domain.account.service.AccountQueryService;
import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class DefaultBasketQueryService implements BasketQueryService {

    private final AccountQueryService accountQueryService;
    private final BasketRepository basketRepository;


    @Override
    public Basket getBasketByToken(HttpServletRequest httpServletRequest) {
        var account = accountQueryService.getIdentityFromToken(httpServletRequest);
        return basketRepository.findByAccountId(account.getId());
    }
}
