package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.User;
import com.wamazon.wamazonservice.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
