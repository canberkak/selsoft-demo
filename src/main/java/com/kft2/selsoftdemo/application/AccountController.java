package com.kft2.selsoftdemo.application;

import com.kft2.selsoftdemo.application.request.SignInRequest;
import com.kft2.selsoftdemo.application.request.SignUpRequest;
import com.kft2.selsoftdemo.domain.account.service.AccountCommandService;
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

    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@RequestBody @Valid SignUpRequest signUpRequest) {
        accountCommandService.singUp(signUpRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> login(@RequestBody @Valid SignInRequest signInRequest) {
        return new ResponseEntity<>(accountCommandService.signIn(signInRequest), HttpStatus.OK);
    }


    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "me", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity<?> getMe(HttpServletRequest req) {
        return null;
    }

    @GetMapping("/refresh")
    public ResponseEntity<?> refresh(HttpServletRequest req) {
        return null;
    }
}
