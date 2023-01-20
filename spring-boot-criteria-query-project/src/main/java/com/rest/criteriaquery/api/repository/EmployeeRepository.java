package com.rest.criteriaquery.api.repository;

import com.rest.criteriaquery.api.entities.Employee;
import com.rest.criteriaquery.api.enumeration.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, EmployeeCustomRepository,EmployeeCriteriaRepository, JpaSpecificationExecutor<Employee> {
    public Employee findEmployeeById(String id);
    public List<Employee> findEmployeeByName(String name);

    public List<Employee> findByGender(Gender gender);
}
