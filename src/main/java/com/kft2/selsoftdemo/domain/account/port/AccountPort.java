package com.kft2.selsoftdemo.domain.account.port;

import com.kft2.selsoftdemo.domain.account.model.Account;

public interface AccountPort {

    Account findByEmail(String email);

    void save(Account account);

    Account findById(Long id);

}
