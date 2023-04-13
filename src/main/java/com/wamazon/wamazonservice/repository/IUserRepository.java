package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends IBaseRepository<User> {

    Optional<User> findByLogin(String login);
}
