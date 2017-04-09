package biezhi;

import io.github.biezhi.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by biezhi on 2017/3/26.
 */
@FeignClient("user-service")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);

    @GetMapping("/users")
    List<User> findAll();

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable("id") Long id);
}
