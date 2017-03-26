package biezhi.controller;

import io.github.biezhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${vip-url}")
    private String vipUrl;

    @GetMapping(value = "/movie/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject(vipUrl + "/users/" + id, User.class);
    }

}
