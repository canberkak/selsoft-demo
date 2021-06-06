package com.kft2.selsoftdemo.domain.basket.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BasketItem {

    private Long id;
    private Long productId;
    private Long basketId;
    private Integer quantity;
    private BigDecimal totalPrice;

    public void updateQuantityAndPrice(Integer quantity, BigDecimal price){
        this.quantity = quantity;
        this.totalPrice = price.multiply(BigDecimal.valueOf(quantity));
    }

}
