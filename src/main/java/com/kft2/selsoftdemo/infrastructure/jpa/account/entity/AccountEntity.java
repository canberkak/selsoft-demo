package com.kft2.selsoftdemo.infrastructure.jpa.account.entity;

import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.model.type.Role;
import com.kft2.selsoftdemo.infrastructure.jpa.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "account")
@Table(name = "account")
public class AccountEntity extends BaseEntity {

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Column
    private String name;

    @Column
    private String company;

    @Column
    private String address;

    @Column
    private String phone;


    public Account toModel() {
        return Account.builder()
                .id(super.getId())
                .email(email)
                .password(password)
                .roles(roles)
                .name(name)
                .company(company)
                .address(address)
                .phone(phone)
                .build();
    }


}
