package com.groupsix.cst438_project3_backend.controllers;

import com.groupsix.cst438_project3_backend.entities.Stories;
import com.groupsix.cst438_project3_backend.entities.Story;
import com.groupsix.cst438_project3_backend.repositories.StoriesRepository;
import com.groupsix.cst438_project3_backend.service.StoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  A controller to handle stories related API endpoints
 */

@RestController
@RequestMapping(path = "/api")
public class StoriesController {
    @Autowired
    StoriesService storiesService;

    @GetMapping(path = "/stories", params = "userId")
    public ResponseEntity<List<Stories>> getAllStoriesByUserId(@RequestParam int userId) {
        List<Stories> storiesList = storiesService.getAllByUserId(userId);
        return ResponseEntity.ok(storiesList);
    }

}
