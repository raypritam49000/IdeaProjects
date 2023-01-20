package com.data.jdbc.rest.api.repository;

import com.data.jdbc.rest.api.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
}
