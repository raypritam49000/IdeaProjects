package com.flayway.migration.api;

import com.flayway.migration.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class SpringbootFlywayMigrationApplication implements CommandLineRunner {

    @Autowired
    @Lazy
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFlywayMigrationApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
      //this.personRepository.save(new Person("Ram Kumar","Ropar","ram@gmail.com",45000.00));
    }
}
