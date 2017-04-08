package io.github.biezhi.jdbc.service;

import io.github.biezhi.jdbc.entity.User;

import java.util.List;

public interface UserService {

    void create(String name);

    int delete(Integer id);

    List<User> getUsers();

    User getById(Integer id);

}
