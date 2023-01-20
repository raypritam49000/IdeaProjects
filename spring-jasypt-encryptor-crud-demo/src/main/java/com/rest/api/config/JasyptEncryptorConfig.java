package com.rest.api.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.security.NoSuchAlgorithmException;

@Configuration
public class JasyptEncryptorConfig {

    @Primary
    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor passwordEncryptor() throws NoSuchAlgorithmException {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("root");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        encryptor.setConfig(config);
        return encryptor;
    }
}
