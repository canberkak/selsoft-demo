package com.kft2.selsoftdemo.domain.account.repository;

import com.kft2.selsoftdemo.domain.account.model.Account;

public interface AccountAdapter {

    Account findByEmail(String email);

    void save(Account account);


}
