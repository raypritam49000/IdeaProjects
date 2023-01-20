package com.rest.criteriaquery.api.specifications;

import com.rest.criteriaquery.api.entities.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification {

    public static Specification<Employee> hasName(String name){
        return ((root,criteriaQuery,criteriaBuilder)->{
            return criteriaBuilder.equal(root.get("name"),name);
        });
    }

    public static Specification<Employee> containName(String name){
        return ((root,criteriaQuery,criteriaBuilder)->{
            return criteriaBuilder.like(root.get("name"),"%"+name+"%");
        });
    }

    public static Specification<Employee> hasDepartment(String department){
        return ((root,criteriaQuery,criteriaBuilder)->{
            return criteriaBuilder.equal(root.get("department"),department);
        });
    }

}
