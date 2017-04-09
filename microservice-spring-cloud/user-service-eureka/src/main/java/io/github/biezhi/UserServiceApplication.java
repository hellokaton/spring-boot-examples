package io.github.biezhi;

import io.github.biezhi.entity.User;
import io.github.biezhi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

    @Bean
    CommandLineRunner clr(UserRepository userRepo) {
        return args -> {
            User u1 = new User("io/github/biezhi", "王爵nice", 24, 100000.22);
            User u2 = new User("rose", "萝丝", 22, 50);
            Stream.of(u1, u2).forEach(userRepo::save);
            userRepo.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
