package com.cloud.consul.server;

import com.cloud.consul.server.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
@RestController
@EnableConfigurationProperties(value = MyConfig.class)
public class SpringCloudConsulServerDemoApplication {

    @Value("${message:Hello}")
    private String message;

    @Value("${my.username}")
    private String username;

    @Value("${my.password}")
    private String password;

    @Autowired
    private MyConfig config;

    @GetMapping("/getConfigData")
    public MyConfig getConfiguration() {
        return config;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulServerDemoApplication.class, args);
    }

    @PostConstruct
    public void init(){
        log.info("Message :: "+message);
        log.info("Username :: "+username);
        log.info("Password :: "+password);
    }

}
