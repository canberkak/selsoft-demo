package com.kft2.selsoftdemo.domain.account.service;

import com.kft2.selsoftdemo.domain.account.model.Account;

public interface AccountQueryService {

    Account findByEmail(String email);
}
