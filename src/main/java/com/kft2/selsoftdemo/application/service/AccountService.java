package com.kft2.selsoftdemo.application.service;

import com.kft2.selsoftdemo.application.request.SignInRequest;
import com.kft2.selsoftdemo.application.request.SignUpRequest;
import com.kft2.selsoftdemo.domain.account.model.Account;

import javax.servlet.http.HttpServletRequest;

public interface AccountService {

    void singUp(SignUpRequest signUpRequest);

    String signIn(SignInRequest signInRequest);

    Account getIdentityFromToken(HttpServletRequest httpServletRequest);

}
