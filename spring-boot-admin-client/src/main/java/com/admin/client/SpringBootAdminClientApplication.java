package com.admin.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBootAdminClientApplication {

    @GetMapping("/message")
    public String getMessage() {
        log.info("Logging for message() method");
        return "Spring Boot Admin Client Example";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClientApplication.class, args);
    }

}
