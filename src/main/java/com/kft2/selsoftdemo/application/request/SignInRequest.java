package com.kft2.selsoftdemo.application.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignInRequest {

    @NotBlank(message = "email cannot be null")
    private String email;

    @NotBlank(message = "password cannot be null")
    private String password;
}
