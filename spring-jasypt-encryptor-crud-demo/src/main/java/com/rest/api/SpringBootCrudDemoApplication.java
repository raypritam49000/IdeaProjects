package com.rest.api;

import com.rest.api.entity.Product;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.AllArgsConstructor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@SpringBootApplication
@EnableEncryptableProperties
@AllArgsConstructor
public class SpringBootCrudDemoApplication {

	private final StringEncryptor encryptor;
	private final EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudDemoApplication.class, args);
	}

	@PostConstruct
	public void init(){
		String username = "root";
		System.out.println("Username ==>> : "+encryptor.encrypt(username));

		String password = "0003pray";
		System.out.println("Password ==>> : "+encryptor.encrypt(password));

		System.out.println(entityManager.createQuery("From Product").getResultList());
	}

}
