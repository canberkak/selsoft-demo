package com.kft2.selsoftdemo.application.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SignInRequest {

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "password cannot be null")
    private String password;
}
