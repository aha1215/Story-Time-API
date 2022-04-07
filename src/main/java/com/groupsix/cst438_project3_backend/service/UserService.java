package com.groupsix.cst438_project3_backend.service;

import com.groupsix.cst438_project3_backend.entities.User;
import com.groupsix.cst438_project3_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findById(int userId) {
        return userRepository.findUserByUserId(userId);
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
