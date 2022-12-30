package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.dto.User;

import java.util.List;

public abstract class UserRepository<T extends User> extends CrudRepository<T> {

    public T findUserByLogin(String searchLogin) {
        for (T user : database) {
            if (user.getLogin().equalsIgnoreCase(searchLogin)) {
                return user;
            }
        }

        return null;
    }
}
