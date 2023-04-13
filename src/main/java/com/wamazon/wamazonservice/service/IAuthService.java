package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.AuthRequest;
import com.wamazon.wamazonservice.dto.AuthResponse;
import com.wamazon.wamazonservice.dto.RegisterRequest;

public interface IAuthService {

    AuthResponse register(RegisterRequest registerRequest);

    AuthResponse login(AuthRequest authRequest);
}
