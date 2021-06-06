package com.kft2.selsoftdemo.infrastructure.jpa.basket.repository;

import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseJpaRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.entity.BasketItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasketItemJpaRepository extends BaseJpaRepository<BasketItemEntity, Long> {

    Optional<BasketItemEntity> findByBasketIdAndProductId(Long basketId, Long productId);

    List<BasketItemEntity> findByBasketId(Long basketId);
}
