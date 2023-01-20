package com.springboot.redis;

import com.springboot.redis.repositories.InsuranceRepository;
import com.springboot.redis.services.InsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@SpringBootApplication
@EnableSwagger2
@AllArgsConstructor
public class SpringBootRestApiDemoApplication implements CommandLineRunner {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceService insuranceService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(insuranceService.findAllInsurances());
        System.out.println(insuranceService.findAllInsurances());
    }
}
