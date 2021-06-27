package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.domain.account.service.AccountQueryService;
import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.port.BasketPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultBasketQueryService implements BasketQueryService {

    private final BasketPort basketPort;

    @Override
    public Basket getBasketByAccountId(Long id) {
        return basketPort.findByAccountId(id);
    }
}
