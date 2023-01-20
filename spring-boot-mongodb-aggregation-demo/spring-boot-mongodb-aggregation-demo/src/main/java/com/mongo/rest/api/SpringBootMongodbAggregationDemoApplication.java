package com.mongo.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringBootMongodbAggregationDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbAggregationDemoApplication.class, args);
    }

}
