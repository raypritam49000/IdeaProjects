package com.data.jdbc.rest.api.repository;

import com.data.jdbc.rest.api.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {

    @Query("SELECT * FROM employee WHERE id =:id")
    List<Employee> findEmployeeById(@Param("id") int id);

    List<Employee> findByName(String name);

    List<Employee> findByNameContaining(String name);

    Page<Employee> findByNameContainingOrEmailContainingOrSalaryContaining(String name, String email, String salary, Pageable pageable);
}
