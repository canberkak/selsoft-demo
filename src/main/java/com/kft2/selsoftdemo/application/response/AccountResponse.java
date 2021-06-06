package com.kft2.selsoftdemo.application.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AccountResponse {

    private String email;
    private String name;
    private String company;
    private String address;
    private String phone;

}
