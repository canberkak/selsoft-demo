package com.kft2.selsoftdemo.domain.account.service;

import com.kft2.selsoftdemo.application.security.JwtTokenProvider;
import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class DefaultAccountQueryService implements AccountQueryService {

    private final AccountPort accountPort;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Account findByEmail(String email) {
        return accountPort.findByEmail(email);
    }

    @Override
    public Account getIdentityFromToken(HttpServletRequest httpServletRequest) {
        return findByEmail(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(httpServletRequest)));
    }
}
