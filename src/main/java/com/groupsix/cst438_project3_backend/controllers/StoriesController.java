package com.groupsix.cst438_project3_backend.controllers;

import com.google.gson.Gson;
import com.groupsix.cst438_project3_backend.entities.Stories;
import com.groupsix.cst438_project3_backend.entities.Story;
import com.groupsix.cst438_project3_backend.service.StoriesService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(path = "/stories", params = {"userId", "story"})
    public ResponseEntity<List<Stories>> getStoriesByUserIdAndStory(@RequestParam int userId, @RequestParam String story) {
        List<Stories> stories = storiesService.findByUserIdAndStory(userId, story);
        return ResponseEntity.ok(stories);
    }

    @PostMapping(path = "/newstories")
    public ResponseEntity<Stories> newStories(@RequestParam int userId, @RequestParam String story, @RequestBody JSONObject jsonStory) {
        Gson gson = new Gson();
        Story storyParent = gson.fromJson(String.valueOf(jsonStory), Story.class);
        Stories stories = new Stories(userId,story, storyParent);
        storiesService.saveStories(stories);
        return ResponseEntity.ok(stories);
    }
}
