package com.kft2.selsoftdemo.infrastructure.jpa.account.repository;

import com.kft2.selsoftdemo.infrastructure.jpa.account.entity.AccountEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountJpaRepository extends BaseJpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByEmail(String email);
}
