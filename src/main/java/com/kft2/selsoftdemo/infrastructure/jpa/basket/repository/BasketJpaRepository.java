package com.kft2.selsoftdemo.infrastructure.jpa.basket.repository;

import com.kft2.selsoftdemo.domain.basket.model.type.BasketStatus;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseJpaRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.basket.entity.BasketEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketJpaRepository extends BaseJpaRepository<BasketEntity, Long> {

    Optional<BasketEntity> findByAccountIdAndBasketStatus(Long accountId, BasketStatus basketStatus);

}
