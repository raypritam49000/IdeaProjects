package com.devglan.springbootrediscache.repo;

import com.devglan.springbootrediscache.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
