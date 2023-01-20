package com.cloud.consul.server.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="my")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyConfig {
	private String username;
	private String password;

}
