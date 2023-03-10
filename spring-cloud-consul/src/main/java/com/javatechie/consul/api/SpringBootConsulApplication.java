package com.javatechie.consul.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value = MyConfig.class)
public class SpringBootConsulApplication {

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
		SpringApplication.run(SpringBootConsulApplication.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println(username+" :: "+password);
	}

}
