package com.kft2.selsoftdemo.domain.basket.model;

import com.kft2.selsoftdemo.domain.basket.model.type.BasketStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
public class Basket {

    private Long id;
    private Long accountId;
    private BigDecimal totalPrice;
    private BasketStatus basketStatus;
    private List<BasketItem> basketItemList;


}
