package com.kft2.selsoftdemo.domain.account.service;

import com.kft2.selsoftdemo.domain.account.model.Account;

import javax.servlet.http.HttpServletRequest;

public interface AccountQueryService {

    Account findByEmail(String email);

    Account getIdentityFromToken(HttpServletRequest httpServletRequest);

}
