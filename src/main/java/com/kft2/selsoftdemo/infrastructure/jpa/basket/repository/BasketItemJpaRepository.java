package com.kft2.selsoftdemo.infrastructure.jpa.basket.repository;

import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseJpaRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.entity.BasketItemEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketItemJpaRepository extends BaseJpaRepository<BasketItemEntity, Long> {
}
