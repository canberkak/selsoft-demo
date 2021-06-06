package com.kft2.selsoftdemo.infrastructure.jpa.cafe.entity;

import com.kft2.selsoftdemo.domain.cafe.model.Cafe;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity(name = "cafe")
@Table(name = "cafe")
public class CafeEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cafe", cascade = CascadeType.ALL)
    private List<ProductEntity> productEntityList;

    public Cafe toModel() {
        return Cafe.builder()
                .id(super.getId())
                .name(name)
                .address(address)
                .phoneNumber(phoneNumber)
                .productList(productEntityList.stream().map(ProductEntity::toModel).collect(Collectors.toList()))
                .build();
    }

}
