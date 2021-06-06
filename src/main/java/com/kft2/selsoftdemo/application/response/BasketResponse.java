package com.kft2.selsoftdemo.application.response;

import com.kft2.selsoftdemo.domain.basket.model.BasketItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class BasketResponse {

    private Long id;
    private BigDecimal totalPrice;
    private List<BasketItem> basketItemList;

}
