package com.data.jdbc.rest.api.repository;

import com.data.jdbc.rest.api.entity.Branches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesRepository extends CrudRepository<Branches, Long>, PagingAndSortingRepository<Branches, Long> {

}