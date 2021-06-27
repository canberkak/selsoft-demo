package com.kft2.selsoftdemo.application.service;

import com.kft2.selsoftdemo.application.request.SignInRequest;
import com.kft2.selsoftdemo.application.request.SignUpRequest;
import com.kft2.selsoftdemo.application.security.JwtTokenProvider;
import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.service.AccountCommandService;
import com.kft2.selsoftdemo.domain.account.service.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class DefaultAccountService implements AccountService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    @Override
    public void singUp(SignUpRequest signUpRequest) {

        final var account = Account.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .roles(signUpRequest.getRole())
                .name(signUpRequest.getName())
                .company(signUpRequest.getCompany())
                .address(signUpRequest.getAddress())
                .phone(signUpRequest.getPhone())
                .build();

        accountCommandService.singUp(account);

    }

    @Override
    public String signIn(SignInRequest signInRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
            return jwtTokenProvider.createToken(signInRequest.getEmail(), accountQueryService.findByEmail(signInRequest.getEmail()).getRoles());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Account getIdentityFromToken(HttpServletRequest httpServletRequest) {
        return accountQueryService.findByEmail(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(httpServletRequest)));
    }
}
