package com.groupsix.cst438_project3_backend.controllers;

import com.groupsix.cst438_project3_backend.entities.User;
import com.groupsix.cst438_project3_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  A controller to handle user related API endpoints
 */

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/newuser")
    public ResponseEntity<User> newAccount(@RequestParam String username,
                                           @RequestParam String password) {
        User user = new User(username, password, false);
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }
}
