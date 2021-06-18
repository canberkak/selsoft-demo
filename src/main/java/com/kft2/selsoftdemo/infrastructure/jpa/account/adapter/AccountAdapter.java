package com.kft2.selsoftdemo.infrastructure.jpa.account.adapter;

import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.port.AccountPort;
import com.kft2.selsoftdemo.infrastructure.jpa.account.entity.AccountEntity;
import com.kft2.selsoftdemo.infrastructure.jpa.account.repository.AccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountAdapter implements AccountPort {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account findByEmail(String email) {
        return accountJpaRepository.findByEmail(email).map(AccountEntity::toModel).orElseThrow(RuntimeException::new);
    }


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
