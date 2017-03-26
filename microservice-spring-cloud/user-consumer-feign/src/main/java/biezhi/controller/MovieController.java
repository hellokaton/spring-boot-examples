package biezhi.controller;

import biezhi.UserFeignClient;
import io.github.biezhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping(value = "/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping(value = "/movies")
    public List<User> findAll() {
        return userFeignClient.findAll();
    }

    @DeleteMapping(value = "/movies/{id}")
    public void delete(@PathVariable Long id) {
        userFeignClient.delete(id);
    }

}
