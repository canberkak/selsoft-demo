package com.kft2.selsoftdemo.domain.account.service;

import com.kft2.selsoftdemo.application.request.SignInRequest;
import com.kft2.selsoftdemo.application.request.SignUpRequest;

public interface AccountCommandService {

    void singUp(SignUpRequest signUpRequest);

    String signIn(SignInRequest signInRequest);
}
