package com.wamazon.wamazonservice.controller;

import com.wamazon.wamazonservice.dto.AuthRequest;
import com.wamazon.wamazonservice.dto.AuthResponse;
import com.wamazon.wamazonservice.dto.RegisterRequest;
import com.wamazon.wamazonservice.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final IAuthService authService;


    @PostMapping("/register")
    public AuthResponse register(@RequestBody @Validated RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }
}
