package com.wamazon.wamazonservice.utils;

import com.wamazon.wamazonservice.dto.UserDetails;
import com.wamazon.wamazonservice.enums.Role;
import io.jsonwebtoken.Claims;

public class JwtUtils {

    public static UserDetails generate(Claims claims) {
        final UserDetails userDetails = new UserDetails();
        userDetails.setRole(Role.valueOf(claims.get("roles", String.class)));
        userDetails.setFirstName(claims.get("firstName", String.class));
        return userDetails;
    }

}
