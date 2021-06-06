package com.kft2.selsoftdemo.application;

import com.kft2.selsoftdemo.application.request.SignUpRequest;
import com.kft2.selsoftdemo.domain.account.model.type.Role;
import com.kft2.selsoftdemo.domain.account.service.AccountCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class InitService {

    private final AccountCommandService accountCommandService;

    /**
     * If we want initial account entity data, we have to use InitService instead of data.sql file in src/resources.
     * This is required because password has to be encrypted by singUp method before inserted into database.
     */

    @PostConstruct
    public void init() {

        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail("1");
        signUpRequest.setPassword("1");
        signUpRequest.setRole(Collections.singletonList(Role.ROLE_ADMIN));
        accountCommandService.singUp(signUpRequest);


    }

}
