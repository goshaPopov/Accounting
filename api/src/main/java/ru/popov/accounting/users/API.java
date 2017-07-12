package ru.popov.accounting.users;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories
@EnableAutoConfiguration
@EnableWebMvc
@SpringBootApplication
public class API {

    public static void main(String[] args) {
        SpringApplication.run(API.class, args);
    }

}
