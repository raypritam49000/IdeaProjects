package com.data.jdbc.rest.api.repository;

import com.data.jdbc.rest.api.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
