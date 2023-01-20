package com.rest.criteriaquery.api.repository;

import com.rest.criteriaquery.api.entities.Employee;

import java.util.List;

public interface EmployeeCustomRepository {
    public List<Employee> findByNameAndDepartment(String name,String department);
}
