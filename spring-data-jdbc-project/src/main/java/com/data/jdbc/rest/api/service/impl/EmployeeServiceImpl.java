package com.data.jdbc.rest.api.service.impl;

import com.data.jdbc.rest.api.dto.EmployeeDTO;
import com.data.jdbc.rest.api.dto.EmployeePageDTO;
import com.data.jdbc.rest.api.entity.Employee;
import com.data.jdbc.rest.api.mappers.EmployeeEntityMapper;
import com.data.jdbc.rest.api.repository.EmployeeRepository;
import com.data.jdbc.rest.api.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        return EmployeeEntityMapper.INSTANCE.toDto(employeeRepository.save(EmployeeEntityMapper.INSTANCE.toEntity(employeeDTO)));
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return EmployeeEntityMapper.INSTANCE.toDtoList((List<Employee>) employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findEmployeeById(int id) {
        return EmployeeEntityMapper.INSTANCE.toDto(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeDTO updateEmployeeById(int id, EmployeeDTO employeeDTO) {
        employeeDTO.setId(id);
        return EmployeeEntityMapper.INSTANCE.toDto(employeeRepository.save(EmployeeEntityMapper.INSTANCE.toEntity(employeeDTO)));
    }

    @Override
    public Boolean deleteEmployeeById(int id) {
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);

        if(optionalEmployee.isPresent()){
            employeeRepository.delete(optionalEmployee.get());
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

    @Override
    public List<EmployeeDTO> findByName(String name) {
        return EmployeeEntityMapper.INSTANCE.toDtoList(employeeRepository.findByName(name));
    }
    @Override
    public EmployeePageDTO searchEmployee(int pageNumber, int pageSize, String sort, String sortOrder){

        Sort.Direction sortDirection = sortOrder.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        PageRequest pageable = PageRequest.of(pageNumber,pageSize, sortDirection, sort);

        Page<Employee> page = employeeRepository.findAll(pageable);
        EmployeePageDTO employeePageDTO = new EmployeePageDTO();
        employeePageDTO.setFirstPage(page.isFirst());
        employeePageDTO.setLastPage(page.isLast());
        employeePageDTO.setEmployeeDTOList(EmployeeEntityMapper.INSTANCE.toDtoList(page.getContent()));
        employeePageDTO.setTotalPages(page.getTotalPages());
        employeePageDTO.setTotalElements(page.getTotalElements());
        employeePageDTO.setPageNumber(page.getNumber());
        employeePageDTO.setPageSize(page.getSize());
        employeePageDTO.setHasNext(page.hasNext());
        employeePageDTO.setHasPrevious(page.hasPrevious());
        employeePageDTO.setHasContent(page.hasContent());
        employeePageDTO.setNumberOfElements(page.getNumberOfElements());

        return employeePageDTO;

    }
}
