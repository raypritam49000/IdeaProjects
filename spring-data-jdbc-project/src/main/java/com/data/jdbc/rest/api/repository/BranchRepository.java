package com.data.jdbc.rest.api.repository;

import com.data.jdbc.rest.api.entity.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Integer>, PagingAndSortingRepository<Branch, Integer> {
}
