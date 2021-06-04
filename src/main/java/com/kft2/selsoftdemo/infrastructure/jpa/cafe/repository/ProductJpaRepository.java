package com.kft2.selsoftdemo.infrastructure.jpa.cafe.repository;

import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseJpaRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.entity.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends BaseJpaRepository<ProductEntity, Long> {
}
