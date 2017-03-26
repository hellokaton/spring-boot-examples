package biezhi;

import io.github.biezhi.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by biezhi on 2017/3/26.
 */
@FeignClient("user-service")
public interface UserFeignClient {

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<User> findAll();

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id);
}
