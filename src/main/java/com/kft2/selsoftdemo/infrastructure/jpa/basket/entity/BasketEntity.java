package com.kft2.selsoftdemo.infrastructure.jpa.basket.entity;

import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.model.type.BasketStatus;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "basket")
@Table(name = "basket")
public class BasketEntity extends BaseEntity {

    @Column
    private Long accountId;

    @Column
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @Column
    @Enumerated(EnumType.STRING)
    private BasketStatus basketStatus = BasketStatus.ACTIVE;

    public Basket toModel() {
        return Basket.builder()
                .id(super.getId())
                .accountId(accountId)
                .totalPrice(totalPrice)
                .basketStatus(basketStatus)
                .build();
    }


}
