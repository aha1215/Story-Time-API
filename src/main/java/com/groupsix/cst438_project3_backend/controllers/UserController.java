package com.groupsix.cst438_project3_backend.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.groupsix.cst438_project3_backend.entities.User;
import com.groupsix.cst438_project3_backend.service.UserService;
import net.bytebuddy.matcher.FilterableList;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *  A controller to handle user related API endpoints
 */

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Create a new user account
     * @param username name
     * @param password password
     * @param isAdmin define if user is admin
     * @return response entity user
     */
    @PostMapping(path = "/newuser")
    public ResponseEntity<User> newAccount(@RequestParam String username,
                                           @RequestParam String password,
                                           @RequestParam boolean isAdmin) {
        User user = new User(username, password, isAdmin);
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    /**
     * Get a user by their username
     * @param username username
     * @return response entity user
     */
    @GetMapping(path = "/user", params = {"username"})
    public ResponseEntity<User> getUserByName(@RequestParam String username) {
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    /**
     * Get a user by their Id
     * @param userId is the user id
     * @return response entity user
     */
    @GetMapping(path = "/user", params = {"userId"})
    public ResponseEntity<User> getUserById(@RequestParam Integer userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok(user);
    }

    /**
     * Get all users
     * @return a list of all users
     */
    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAll();
        return ResponseEntity.ok(userList);
    }

    @DeleteMapping(path = "user/delete")
    public String deleteUser(@RequestParam Boolean isAdmin, @RequestParam JSONObject jsonUser) {
        if (isAdmin) {
            Gson gson = new Gson();
            User user = gson.fromJson(String.valueOf(jsonUser), User.class);
            userService.deleteUser(user);
            return "User deleted successfully";
        } else {
            return "You are not an admin";
        }
    }

    @DeleteMapping(path = "users/delete")
    public String deleteUsers(@RequestParam Boolean isAdmin, @RequestBody JSONObject[] userIdList) {
        if (isAdmin && userIdList.length > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            Type listType = new TypeToken<List<Integer>>() {}.getType();
            Gson gson = new Gson();
           for (JSONObject userJson : userIdList) {
               Integer id = gson.fromJson(String.valueOf(userJson), listType);
               list.add(id);
           }
           userService.deleteUser(list);
           return "Users deleted successfully!";
        } else {
            return "You are not an admin or list is empty!";
        }
    }
}
