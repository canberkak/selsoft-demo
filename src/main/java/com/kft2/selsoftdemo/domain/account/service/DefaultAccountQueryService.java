package com.kft2.selsoftdemo.domain.account.service;

import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.infrastructure.jpa.account.adapter.AccountAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAccountQueryService implements AccountQueryService {

    private final AccountAdapter accountAdapter;

    @Override
    public Account findByEmail(String email) {
        return accountAdapter.findByEmail(email);
    }
}
