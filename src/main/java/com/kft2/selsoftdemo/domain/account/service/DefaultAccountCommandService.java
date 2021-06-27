package com.kft2.selsoftdemo.domain.account.service;

import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultAccountCommandService implements AccountCommandService {

    private final AccountPort accountPort;

    @Transactional
    @Override
    public void singUp(Account account) {
        accountPort.save(account);
    }


}
