package com.groupsix.cst438_project3_backend.service;

import com.groupsix.cst438_project3_backend.entities.User;
import com.groupsix.cst438_project3_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User updateUser(int userId, User user) {
        User nUser = userRepository.findUserByUserId(userId);

        nUser.setUsername(user.getUsername());
        nUser.setPassword(user.getUsername());
        nUser.setAdmin(user.isAdmin());

        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findById(int userId) {
        return userRepository.findUserByUserId(userId);
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
