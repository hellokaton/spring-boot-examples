package io.github.biezhi.hystrix.feign;

import io.github.biezhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHystrixController {

    @Autowired
    private FeignHystrixService feignHystrixService;

    @GetMapping("/feign/{id}")
    public User findById(@PathVariable Long id) {
        return this.feignHystrixService.findByIdFeign(id);
    }
}