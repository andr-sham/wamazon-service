package com.wamazon.wamazonservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthRequest {

    @NotNull
    private String login;

    @NotNull
    private String password;
}
