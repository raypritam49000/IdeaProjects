package com.rest.criteriaquery.api.service.impl;

import com.rest.criteriaquery.api.dto.EmployeeDTO;
import com.rest.criteriaquery.api.dto.EmployeePage;
import com.rest.criteriaquery.api.dto.EmployeePageDTO;
import com.rest.criteriaquery.api.dto.EmployeeSearchCriteria;
import com.rest.criteriaquery.api.entities.Employee;
import com.rest.criteriaquery.api.enumeration.Gender;
import com.rest.criteriaquery.api.mapper.EmployeeEntityMapper;
import com.rest.criteriaquery.api.repository.EmployeeRepository;
import com.rest.criteriaquery.api.search.GenericEntitySpecifications;
import com.rest.criteriaquery.api.search.SearchBuilder;
import com.rest.criteriaquery.api.service.EmployeeService;
import com.rest.criteriaquery.api.specifications.EmployeeSpecification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private  final EntityManager entityManager;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EntityManager entityManager) {
        this.employeeRepository = employeeRepository;
        this.entityManager = entityManager;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeEntityMapper.INSTANCE.toEntity(employeeDTO);
        return EmployeeEntityMapper.INSTANCE.toDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDTO> findByNameAndDepartment(String name, String department){
        return EmployeeEntityMapper.INSTANCE.toDtoList(employeeRepository.findByNameAndDepartment(name,department));
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return EmployeeEntityMapper.INSTANCE.toDtoList(employeeRepository.findAll());
    }

    @Override
    public List<EmployeeDTO> findByNameAndDepartmentSpecifications(String name, String department) {
        Specification<Employee> specifications = Specification.where(EmployeeSpecification.hasName(name).and(EmployeeSpecification.hasDepartment(department)));
        return EmployeeEntityMapper.INSTANCE.toDtoList(employeeRepository.findAll(specifications));
    }

    @Override
    public EmployeeDTO findEmployeeById(String id) {
        return EmployeeEntityMapper.INSTANCE.toDto(employeeRepository.findEmployeeById(id));
    }

    @Override
    public List<EmployeeDTO> findEmployeeByName(String name) {
        return EmployeeEntityMapper.INSTANCE.toDtoList(employeeRepository.findEmployeeByName(name));
    }

    @Override
    public Page<Employee> getEmployees(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria) {
        return employeeRepository.findWithFilter(employeePage,employeeSearchCriteria);
    }

    @Override
    public EmployeePageDTO searchEmployees(int pageNumber, int pageSize, String sort, String sortOrder, EmployeeDTO employeeDTO) {

        if (sort == null || sort.equals("") || sort.equals("creationDate"))
            sort = "id";

        if (sortOrder == null || sortOrder.equals("")) {
            sortOrder = "ASCENDING";
        }

        SearchBuilder<Employee> searchBuilder = new SearchBuilder<>(pageNumber, pageSize, entityManager, Employee.class);

        switch (sort) {
            case "name":
                searchBuilder.setSortCriterion(sortOrder, null, "name");
                break;
            case "email":
                searchBuilder.setSortCriterion(sortOrder, null,"email");
                break;
            case "gender":
                searchBuilder.setSortCriterion(sortOrder, null, "gender");
            case "city":
                searchBuilder.setSortCriterion(sortOrder, null, "city");
                break;
            case "department":
                searchBuilder.setSortCriterion(sortOrder, null, "department");
                break;
            default:
                searchBuilder.setSortCriterion(sortOrder, null, sort);
        }


        searchBuilder.addSearchFilter(GenericEntitySpecifications.includesMatchText(StringUtils.trimToNull(employeeDTO.getName()), "name"));
        searchBuilder.addSearchFilter(GenericEntitySpecifications.exactMatchText(StringUtils.trimToNull(employeeDTO.getDepartment()), "description"));
        searchBuilder.addSearchFilter(GenericEntitySpecifications.matchObjectIn(employeeDTO.getGender(), "gender"));
        searchBuilder.addSearchFilter(GenericEntitySpecifications.includesMatchText(StringUtils.trimToNull(employeeDTO.getId()), "id"));
        searchBuilder.addSearchFilter(GenericEntitySpecifications.includesMatchText(StringUtils.trimToNull(employeeDTO.getCity()), "city"));
        searchBuilder.addSearchFilter(GenericEntitySpecifications.exactMatchText(StringUtils.trimToNull(employeeDTO.getEmail()), "email"));

        return searchBuilder.getAsPageDTO(new EmployeePageDTO(), EmployeeEntityMapper.INSTANCE, sort, sortOrder,
                "Employee");
    }
}
