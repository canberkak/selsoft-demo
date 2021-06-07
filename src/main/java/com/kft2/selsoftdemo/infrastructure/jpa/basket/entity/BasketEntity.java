package com.kft2.selsoftdemo.infrastructure.jpa.basket.entity;

import com.kft2.selsoftdemo.domain.basket.model.Basket;
import com.kft2.selsoftdemo.domain.basket.model.BasketItem;
import com.kft2.selsoftdemo.domain.basket.model.type.BasketStatus;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity(name = "basket")
@Table(name = "basket")
public class BasketEntity extends BaseEntity {

    @Column
    private Long accountId;

    @Column
    private BigDecimal totalPrice;

    @Column
    @Enumerated(EnumType.STRING)
    private BasketStatus basketStatus = BasketStatus.ACTIVE;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketItemEntity> basketItemEntityList;


    public Basket toModel() {
        List<BasketItem> basketItemList = this.basketItemEntityList != null
                ? basketItemEntityList.stream().map(BasketItemEntity::toModel).collect(Collectors.toList())
                : new ArrayList<>();
        return Basket.builder()
                .id(super.getId())
                .accountId(accountId)
                .totalPrice(totalPrice)
                .basketStatus(basketStatus)
                .basketItemList(basketItemList)
                .build();
    }

}
