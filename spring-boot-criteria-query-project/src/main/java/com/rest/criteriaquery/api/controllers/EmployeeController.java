package com.rest.criteriaquery.api.controllers;

import com.rest.criteriaquery.api.dto.EmployeeDTO;
import com.rest.criteriaquery.api.dto.EmployeePage;
import com.rest.criteriaquery.api.dto.EmployeePageDTO;
import com.rest.criteriaquery.api.dto.EmployeeSearchCriteria;
import com.rest.criteriaquery.api.entities.Employee;
import com.rest.criteriaquery.api.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return this.employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/{name}/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> findByNameAndDepartment(@PathVariable("name") String name,@PathVariable("department") String department){
      return  employeeService.findByNameAndDepartment(name,department);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/specifications/{name}/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> findByNameAndDepartmentSpecifications(@PathVariable("name") String name,@PathVariable("department") String department){
        return employeeService.findByNameAndDepartmentSpecifications(name, department);
    }

    @ApiOperation(value = "Gets employee by ID", response = EmployeeDTO.class, notes = "Employee must exist")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"), @ApiResponse(code = 404, message = "Employee not found")})
    @GetMapping("/findById/{id}")
    public EmployeeDTO findEmployeeById(@PathVariable("id") String id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<EmployeeDTO> findEmployeeByName(@PathVariable("name") String name){
        return employeeService.findEmployeeByName(name);
    }

    @GetMapping("/search")
    public Page<Employee> getEmployees(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria){
        return employeeService.getEmployees(employeePage,employeeSearchCriteria);
    }

    @GetMapping("/searchAllEmployees")
    public EmployeePageDTO searchEmployees(@RequestParam(name = "pageNumber",defaultValue = "0") int pageNumber,@RequestParam(name="pageSize",required = false,defaultValue = "15") int pageSize,
                                           @RequestParam(name="sort",required = false) String sort,@RequestParam(name="sortOrder",required = false) String sortOrder, EmployeeDTO employeeDTO){
        return employeeService.searchEmployees(pageNumber,pageSize,sort,sortOrder,employeeDTO);
    }

}
