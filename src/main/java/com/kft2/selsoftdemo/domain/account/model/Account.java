package com.kft2.selsoftdemo.domain.account.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Account {

    private String email;
    private String password;
    private String name;
    private String company;
}
