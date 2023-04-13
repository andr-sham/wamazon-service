package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.AuthRequest;
import com.wamazon.wamazonservice.dto.AuthResponse;
import com.wamazon.wamazonservice.dto.RegisterRequest;
import com.wamazon.wamazonservice.entity.User;
import com.wamazon.wamazonservice.enums.Role;
import com.wamazon.wamazonservice.exception.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService implements IAuthService {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        Optional<User> userOptional = userService.getByLogin(registerRequest.getLogin());

        if (userOptional.isPresent()) {
            throw new AuthException("Пользователь с таким именем уже существует");
        }

        User user = User.builder()
                .role(Role.ADMIN)
                .login(registerRequest.getLogin())
                .password(registerRequest.getPassword())
                .firstName(registerRequest.getFirstName()).build();

        user = userService.save(user);

        final String accessToken = jwtProvider.generateAccessToken(user);
        return new AuthResponse(accessToken);
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        User user = userService.getByLogin(authRequest.getLogin())
                .orElseThrow(() -> new AuthException("Пользователь не найден"));

        if (user.getPassword().equals(authRequest.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            return new AuthResponse(accessToken);
        } else {
            throw new AuthException("Неправильный пароль");
        }
    }

}
