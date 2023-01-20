package com.data.jdbc.rest.api.repository;

import com.data.jdbc.rest.api.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>, PagingAndSortingRepository<Student,Integer> {
}
