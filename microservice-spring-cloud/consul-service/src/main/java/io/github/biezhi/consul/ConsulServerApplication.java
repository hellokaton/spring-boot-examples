package io.github.biezhi.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConsulServerApplication {

    @Autowired
    private Environment environment;

    @RequestMapping("/hello")
    public Object hello(@RequestParam String name) {
        if (environment.getActiveProfiles()[0].equalsIgnoreCase("dev")) {
            System.out.println("1111111111111");
            return "hello " + name + ", from instance-1";
        } else {
            System.out.println("2222222222222");
            return "hello " + name + ", from instance-2";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulServerApplication.class, args);
    }
}