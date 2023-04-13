package com.wamazon.wamazonservice.entity;

import com.wamazon.wamazonservice.enums.Role;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends VersionedEntity {

    private String firstName;

    private String login;

    private String password;

    private Role role = Role.ADMIN;
}
