package com.kft2.selsoftdemo.application.mapper;

import com.kft2.selsoftdemo.application.response.AccountResponse;
import com.kft2.selsoftdemo.domain.account.model.Account;

public class AccountMapper {

    public static AccountResponse accountToAccountResponse(Account account) {
        return AccountResponse.builder()
                .email(account.getEmail())
                .name(account.getName())
                .company(account.getCompany())
                .phone(account.getPhone())
                .address(account.getAddress())
                .build();
    }
}
