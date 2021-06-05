package com.kft2.selsoftdemo.domain.account.model;

import com.kft2.selsoftdemo.domain.account.model.type.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class Account {

    private Long id;
    private String email;
    private String password;
    private List<Role> roles;
    private String name;
    private String company;
    private String address;
    private String phone;
}
