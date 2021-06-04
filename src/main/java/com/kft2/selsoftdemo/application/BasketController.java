package com.kft2.selsoftdemo.application;

import com.kft2.selsoftdemo.application.request.AddItemToBasketRequest;
import com.kft2.selsoftdemo.domain.basket.service.BasketCommandService;
import com.kft2.selsoftdemo.domain.basket.service.BasketQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketQueryService basketQueryService;
    private final BasketCommandService basketCommandService;

    @PostMapping("/add-item")
    public ResponseEntity<?> addItemToBasket(@RequestBody @Valid AddItemToBasketRequest addItemToBasketRequest) {
        basketCommandService.addItemToBasket(addItemToBasketRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
