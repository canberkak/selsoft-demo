package com.kft2.selsoftdemo.infrastructure.jpa.cafe.entity;


import com.kft2.selsoftdemo.domain.cafe.model.Product;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "product")
@Table(name = "product")
public class ProductEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String details;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "cafe_id")
    private CafeEntity cafe;


    public Product toModel() {
        return Product.builder()
                .id(super.getId())
                .name(name)
                .details(details)
                .price(price)
                .caffeId(cafe.getId())
                .build();
    }

}
