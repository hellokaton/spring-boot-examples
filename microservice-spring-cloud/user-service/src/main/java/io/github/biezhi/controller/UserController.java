package io.github.biezhi.controller;

import io.github.biezhi.entity.User;
import io.github.biezhi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @GetMapping(value = "/users")
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
