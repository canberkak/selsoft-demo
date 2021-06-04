package com.kft2.selsoftdemo.infrastructure.jpa.cafe.repository;

import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseJpaRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.cafe.entity.CafeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeJpaRepository extends BaseJpaRepository<CafeEntity,Long> {
}
