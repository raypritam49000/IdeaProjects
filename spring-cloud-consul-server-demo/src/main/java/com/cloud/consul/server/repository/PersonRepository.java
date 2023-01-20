package com.cloud.consul.server.repository;


import com.cloud.consul.server.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {
}
