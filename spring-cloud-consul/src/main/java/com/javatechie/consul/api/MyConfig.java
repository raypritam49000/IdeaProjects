package com.javatechie.consul.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="my")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyConfig {
	
	
	private String username;
	private String password;

}
