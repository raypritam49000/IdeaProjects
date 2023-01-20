package com.data.jdbc.rest.api.service;

import com.data.jdbc.rest.api.dto.EmployeeDTO;
import com.data.jdbc.rest.api.dto.EmployeePageDTO;

import java.util.List;

public interface IEmployeeService {
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    public List<EmployeeDTO> findAllEmployees();
    public EmployeeDTO findEmployeeById(int id);
    public EmployeeDTO updateEmployeeById(int id,EmployeeDTO employeeDTO);
    public Boolean deleteEmployeeById(int id);
    List<EmployeeDTO> findByName(String name);
     EmployeePageDTO searchEmployee(int pageNumber, int pageSize, String sort, String sortOrder);
}
