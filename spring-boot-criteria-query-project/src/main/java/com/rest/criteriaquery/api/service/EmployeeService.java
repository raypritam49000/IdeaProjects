package com.rest.criteriaquery.api.service;

import com.rest.criteriaquery.api.dto.EmployeeDTO;
import com.rest.criteriaquery.api.dto.EmployeePage;
import com.rest.criteriaquery.api.dto.EmployeePageDTO;
import com.rest.criteriaquery.api.dto.EmployeeSearchCriteria;
import com.rest.criteriaquery.api.entities.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    public List<EmployeeDTO> findByNameAndDepartment(String name, String department);
    public List<EmployeeDTO> findAllEmployees();
    public List<EmployeeDTO> findByNameAndDepartmentSpecifications(String name, String department);
    public EmployeeDTO findEmployeeById(String id);
    public List<EmployeeDTO> findEmployeeByName(String name);
    public Page<Employee> getEmployees(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria);
    public EmployeePageDTO searchEmployees(int pageNumber, int pageSize, String sort, String sortOrder, EmployeeDTO employeeDTO);
}
