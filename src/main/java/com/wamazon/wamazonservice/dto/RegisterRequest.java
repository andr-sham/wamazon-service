package com.wamazon.wamazonservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String login;

    @NotNull
    private String password;
}
