package com.kft2.selsoftdemo.application.security;


import com.kft2.selsoftdemo.domain.account.model.Account;
import com.kft2.selsoftdemo.domain.account.service.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final AccountQueryService accountQueryService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Account account = accountQueryService.findByEmail(email);

        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password(account.getPassword())
                .authorities(account.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}
