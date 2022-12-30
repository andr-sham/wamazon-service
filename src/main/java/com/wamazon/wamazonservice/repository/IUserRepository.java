package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.dto.User;

public interface IUserRepository<T extends User> {

    T findUserByLogin(String login);

    T saveUser(String login, String password);

    T updateUser(T user);
}
