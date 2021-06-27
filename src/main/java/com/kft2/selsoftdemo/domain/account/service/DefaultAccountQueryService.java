package com.kft2.selsoftdemo.domain.account.service;

import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAccountQueryService implements AccountQueryService {

    private final AccountPort accountPort;

    @Override
    public Account findByEmail(String email) {
        return accountPort.findByEmail(email);
    }

    @Override
    public Account findById(Long id) {
        return accountPort.findById(id);
    }
}
