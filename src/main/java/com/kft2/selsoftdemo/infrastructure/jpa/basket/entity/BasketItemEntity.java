package com.kft2.selsoftdemo.infrastructure.jpa.basket.entity;

import com.kft2.selsoftdemo.domain.basket.model.BasketItem;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "basketItem")
@Table(name = "basketItem")
public class BasketItemEntity extends BaseEntity {

    @Column
    private Long productId;

    @Column
    private Long basketId;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal totalPrice;

    public BasketItem toModel() {
        return BasketItem.builder()
                .id(super.getId())
                .productId(productId)
                .basketId(basketId)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();
    }
}
