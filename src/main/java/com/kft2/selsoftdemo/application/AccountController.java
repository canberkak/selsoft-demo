package com.kft2.selsoftdemo.application;

import com.kft2.selsoftdemo.application.mapper.AccountMapper;
import com.kft2.selsoftdemo.application.request.SignInRequest;
import com.kft2.selsoftdemo.application.request.SignUpRequest;
import com.kft2.selsoftdemo.application.response.AccountResponse;
import com.kft2.selsoftdemo.domain.account.service.AccountCommandService;
import com.kft2.selsoftdemo.domain.account.service.AccountQueryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
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

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        accountCommandService.singUp(signUpRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody @Valid SignInRequest signInRequest) {
        var token = accountCommandService.signIn(signInRequest);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }


    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @ApiOperation(value = "me", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity<AccountResponse> getMe(HttpServletRequest httpServletRequest) {
        var account = AccountMapper.accountToAccountResponse(accountQueryService.getIdentityFromToken(httpServletRequest));
        return new ResponseEntity<>(account, HttpStatus.OK);

    }


}
