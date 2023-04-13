package com.wamazon.wamazonservice.dto;

import com.wamazon.wamazonservice.enums.Role;

public class UserDto extends VersionedDto {

    private String firstName;

    private String login;

    private String password;

    private Role role;
}
