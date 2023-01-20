package com.vault.server.demo;

import com.vault.server.demo.config.AppConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
@Slf4j
public class SpringBootVaultServerDemoApplication implements ApplicationRunner {

    @Autowired
    private  AppConfig appConfig;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootVaultServerDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Inside Main Method");
        log.info("Values From Vault Server");
        log.info("Username :: "+appConfig.getUsername());
        log.info("Password :: "+appConfig.getPassword());
        log.info("Username :: "+username);
        log.info("Password :: "+password);
    }
}
