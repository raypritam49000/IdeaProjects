package com.rest.criteriaquery.api.repository.impl;

import com.rest.criteriaquery.api.dto.EmployeePage;
import com.rest.criteriaquery.api.dto.EmployeeSearchCriteria;
import com.rest.criteriaquery.api.entities.Employee;
import com.rest.criteriaquery.api.enumeration.Gender;
import com.rest.criteriaquery.api.repository.EmployeeCriteriaRepository;
import org.springframework.data.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeCriteriaRepositoryImpl implements EmployeeCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public EmployeeCriteriaRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public Page<Employee> findWithFilter(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria) {

        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate predicate = getPredicate(employeeSearchCriteria, employeeRoot);
        criteriaQuery.where(predicate);
        setOrder(employeePage, criteriaQuery, employeeRoot);

        TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(employeePage.getPageNumber() * employeePage.getPageSize());
        typedQuery.setMaxResults(employeePage.getPageSize());

        Pageable pageable = getPageable(employeePage);

        Long employeesCount = getEmployeesCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, employeesCount);
    }


    private Predicate getPredicate(EmployeeSearchCriteria employeeSearchCriteria, Root<Employee> employeeRoot) {
        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(employeeSearchCriteria.getId())) {
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("id"), "%" + employeeSearchCriteria.getId() + "%")
            );
        }

        if (Objects.nonNull(employeeSearchCriteria.getName())) {
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("name"), "%" + employeeSearchCriteria.getName() + "%")
            );
        }

        if (Objects.nonNull(employeeSearchCriteria.getCity())) {
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("city"), "%" + employeeSearchCriteria.getCity() + "%")
            );
        }

        if (Objects.nonNull(employeeSearchCriteria.getEmail())) {
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("email"), "%" + employeeSearchCriteria.getEmail() + "%")
            );
        }

        if (Objects.nonNull(employeeSearchCriteria.getDepartment())) {
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("department"), "%" + employeeSearchCriteria.getDepartment() + "%")
            );
        }

        if (Objects.nonNull(employeeSearchCriteria.getGender())) {
            predicates.add(
                    criteriaBuilder.equal(employeeRoot.get("gender"), Gender.valueOf(employeeSearchCriteria.getGender().toString()))
            );
        }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }


    private void setOrder(EmployeePage employeePage, CriteriaQuery<Employee> criteriaQuery, Root<Employee> employeeRoot) {

        if (employeePage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(employeeRoot.get(employeePage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(employeeRoot.get(employeePage.getSortBy())));
        }
    }


    private Pageable getPageable(EmployeePage employeePage) {
        Sort sort = Sort.by(employeePage.getSortDirection(), employeePage.getSortBy());
        return PageRequest.of(employeePage.getPageNumber(), employeePage.getPageSize(), sort);
    }

    private Long getEmployeesCount(Predicate predicate) {
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Employee> countRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
