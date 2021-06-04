package com.kft2.selsoftdemo.infrastructure.jpa.basket.repository;

import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseJpaRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.entity.BasketEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketJpaRepository extends BaseJpaRepository<BasketEntity, Long> {
}
