package com.rest.criteriaquery.api.repository.impl;

import com.rest.criteriaquery.api.entities.Employee;
import com.rest.criteriaquery.api.repository.EmployeeCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    private final EntityManager entityManager;

    public EmployeeCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findByNameAndDepartment(String name, String department) {

       CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
       CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

       Root<Employee> employee = cq.from(Employee.class);

       Predicate namePredicate = cb.equal(employee.get("name"),name);
       Predicate departmentPredicate = cb.equal(employee.get("department"),department);

       cq.where(namePredicate,departmentPredicate);

       TypedQuery<Employee> query = entityManager.createQuery(cq);

       return query.getResultList();
    }
}
