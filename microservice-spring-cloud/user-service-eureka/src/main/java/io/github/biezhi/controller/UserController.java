package io.github.biezhi.controller;

import io.github.biezhi.entity.User;
import io.github.biezhi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据id获取用户数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/users/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    /**
     * 查询所有用户数据
     *
     * @return
     */
    @GetMapping(value = "/users")
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    /**
     * 保存一条用户信息
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/users")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/users/{id}")
    public boolean delete(@PathVariable Long id) {
        userRepository.delete(id);
        return true;
    }
}
