package com.rest.criteriaquery.api;
import com.rest.criteriaquery.api.enumeration.Gender;
import com.rest.criteriaquery.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@EnableSwagger2
@SpringBootApplication
public class SpringBootCriteriaQueryProjectApplication {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCriteriaQueryProjectApplication.class, args);
    }

    @PostConstruct
    public void init(){
        System.out.println(employeeRepository.findByGender(Gender.MALE));
    }

}
