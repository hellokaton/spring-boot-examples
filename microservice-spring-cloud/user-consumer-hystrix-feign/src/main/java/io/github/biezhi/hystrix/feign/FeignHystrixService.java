package io.github.biezhi.hystrix.feign;

import io.github.biezhi.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", fallback = FeignHystrixService.HystrixClientFallback.class)
public interface FeignHystrixService {

    @GetMapping("/{id}")
    User findByIdFeign(@PathVariable("id") Long id);

    /**
     * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，
     * 当然也可以单独写一个fallback类。
     */
    @Component
    static class HystrixClientFallback implements FeignHystrixService {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

        /**
         * hystrix fallback方法
         *
         * @param id id
         * @return 默认的用户
         */
        @Override
        public User findByIdFeign(Long id) {
            HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
            User user = new User();
            user.setId(-1L);
            user.setUsername("default username");
            user.setAge(0);
            return user;
        }
    }

}