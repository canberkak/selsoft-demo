package com.kft2.selsoftdemo.domain.basket.service;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.domain.cafe.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultBasketCommandService implements BasketCommandService {

    private final ProductRepository productRepository;

    @Override
    public void addItemToBasket(AddItemToBasketRequest addItemToBasketRequest) {
        var product = productRepository.findById(addItemToBasketRequest.getProductId());

    }
}
