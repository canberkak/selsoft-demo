package com.kft2.selsoftdemo.application.request;

import com.kft2.selsoftdemo.domain.account.model.type.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SignUpRequest {

    @NotBlank(message = "email cannot be null")
    private String email;

    @NotBlank(message = "name cannot be null")
    private String name;

    @NotBlank(message = "password cannot be null")
    private String password;

    @NotBlank(message = "company cannot be null")
    private String company;

    @NotBlank(message = "address cannot be null")
    private String address;

    @NotBlank(message = "phone cannot be null")
    private String phone;

    @NotNull
    private List<Role> role;

}
