package com.vault.server.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppConfig {
    private String username;
    private String password;
}
