package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.User;

import java.util.Optional;

public interface IUserService {

    User save(User user);

    Optional<User> getByLogin(String login);

}
