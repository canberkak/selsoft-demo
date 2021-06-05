package com.kft2.selsoftdemo.application.request;

import com.kft2.selsoftdemo.domain.account.model.type.Role;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SignUpRequest {

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "password cannot be null")
    private String password;

    @NotNull(message = "company cannot be null")
    private String company;

    @NotNull(message = "address cannot be null")
    private String address;

    @NotNull(message = "phone cannot be null")
    private String phone;

    @NotNull
    private List<Role> role; //todo separate endpoint for admin sing up , remove ROLE from regular endpoint

}
