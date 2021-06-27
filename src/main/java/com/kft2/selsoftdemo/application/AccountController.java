package com.kft2.selsoftdemo.application;

import com.kft2.selsoftdemo.application.mapper.AccountMapper;
import com.kft2.selsoftdemo.application.request.SignInRequest;
import com.kft2.selsoftdemo.application.request.SignUpRequest;
import com.kft2.selsoftdemo.application.response.AccountResponse;
import com.kft2.selsoftdemo.application.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        accountService.singUp(signUpRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody @Valid SignInRequest signInRequest) {
        var token = accountService.signIn(signInRequest);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }


    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<AccountResponse> getMe(HttpServletRequest httpServletRequest) {
        var account = AccountMapper.accountToAccountResponse(accountService.getIdentityFromToken(httpServletRequest));
        return new ResponseEntity<>(account, HttpStatus.OK);

    }


}
