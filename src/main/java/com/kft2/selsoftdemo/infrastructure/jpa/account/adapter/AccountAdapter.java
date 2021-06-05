package com.kft2.selsoftdemo.infrastructure.jpa.account.adapter;

import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.repository.AccountRepository;
import com.kft2.selsoftdemo.infrastructure.jpa.account.entity.AccountEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.account.repository.AccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AccountAdapter implements AccountRepository {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account findByEmail(String email) {
        return accountJpaRepository.findByEmail(email).map(AccountEntity::toModel).orElseThrow(RuntimeException::new); //todo custom exception
    }


    @Transactional
    @Override
    public void save(Account account) {

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setEmail(account.getEmail());
        accountEntity.setPassword(account.getPassword());
        accountEntity.setName(account.getName());
        accountEntity.setCompany(account.getCompany());
        accountEntity.setAddress(account.getAddress());
        accountEntity.setPhone(account.getPhone());
        accountEntity.setRoles(account.getRoles());
        accountJpaRepository.save(accountEntity);

    }

}
