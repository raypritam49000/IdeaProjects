package com.data.jdbc.rest.api.repository;

import com.data.jdbc.rest.api.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>, PagingAndSortingRepository<Subject,Long> {

}