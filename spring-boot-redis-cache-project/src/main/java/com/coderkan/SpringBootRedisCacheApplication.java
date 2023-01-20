package com.coderkan;

import com.coderkan.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@EnableSwagger2
@SpringBootApplication
@AllArgsConstructor
public class SpringBootRedisCacheApplication {

	private final CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisCacheApplication.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println(customerService.getAll());
		System.out.println(customerService.getAll());
	}

}
