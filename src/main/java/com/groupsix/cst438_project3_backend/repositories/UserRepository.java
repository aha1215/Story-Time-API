package com.groupsix.cst438_project3_backend.repositories;

import com.groupsix.cst438_project3_backend.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByUserId(int userId);
    User findUserByUsername(String username);
}
