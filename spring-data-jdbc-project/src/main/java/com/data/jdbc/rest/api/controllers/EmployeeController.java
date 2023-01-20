package com.data.jdbc.rest.api.controllers;

import com.data.jdbc.rest.api.dto.EmployeeDTO;
import com.data.jdbc.rest.api.dto.EmployeePageDTO;
import com.data.jdbc.rest.api.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/findByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> getAllEmployeesByName(@PathVariable("name") String name) {
        return employeeService.findByName(name);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeById(id, employeeDTO);
    }

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO getEmployee(@PathVariable("id") int id) {
        return employeeService.findEmployeeById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<Object, Object>> deleteEmployee(@PathVariable("id") int id) {
        Boolean isDeleted = employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(Map.of("message", "Success", "status", 200), HttpStatus.OK);
    }

    @PostMapping("/search")
    public EmployeePageDTO searchEmployee(
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize,
            @RequestParam(name = "sort", defaultValue = "id") String sort,
            @RequestParam(name = "sortOrder", defaultValue = "asc") String sortOrder
    ) {
        return employeeService.searchEmployee(pageNumber, pageSize, sort, sortOrder);
    }
}
