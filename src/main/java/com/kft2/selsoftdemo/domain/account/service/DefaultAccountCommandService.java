package com.kft2.selsoftdemo.domain.account.service;

import com.kft2.selsoftdemo.application.request.SignInRequest;
import com.kft2.selsoftdemo.application.request.SignUpRequest;
import com.kft2.selsoftdemo.application.security.JwtTokenProvider;
import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultAccountCommandService implements AccountCommandService {

    private final AccountPort accountPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;


    @Transactional
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

        accountPort.save(account);

    }

    @Transactional
    @Override
    public String signIn(SignInRequest signInRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
            return jwtTokenProvider.createToken(signInRequest.getEmail(), accountPort.findByEmail(signInRequest.getEmail()).getRoles());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


}
