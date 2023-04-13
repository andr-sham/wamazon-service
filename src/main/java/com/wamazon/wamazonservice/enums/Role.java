package com.wamazon.wamazonservice.enums;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    ADMIN("ADMIN"),

    SELLER("SELLER"),

    BUYER("BUYER");

    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }
}
