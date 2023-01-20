package com.rest.criteriaquery.api.repository;

import com.rest.criteriaquery.api.dto.EmployeePage;
import com.rest.criteriaquery.api.dto.EmployeeSearchCriteria;
import com.rest.criteriaquery.api.entities.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeCriteriaRepository {
    public Page<Employee> findWithFilter(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria);
}
