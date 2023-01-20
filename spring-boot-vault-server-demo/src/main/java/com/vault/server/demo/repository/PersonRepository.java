package com.vault.server.demo.repository;

import com.vault.server.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {
}
