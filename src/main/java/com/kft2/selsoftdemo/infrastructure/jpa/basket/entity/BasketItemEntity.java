package com.kft2.selsoftdemo.infrastructure.jpa.basket.entity;

import com.kft2.selsoftdemo.domain.basket.model.BasketItem;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.entity.CafeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "basketItem")
@Table(name = "basketItem")
public class BasketItemEntity extends BaseEntity {

    @Column
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private BasketEntity basket;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal totalPrice;

    public BasketItem toModel() {
        return BasketItem.builder()
                .id(super.getId())
                .productId(productId)
                .basketId(basket.getId())
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();
    }
}
