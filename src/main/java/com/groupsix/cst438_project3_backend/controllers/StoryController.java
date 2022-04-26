package com.groupsix.cst438_project3_backend.controllers;

import com.groupsix.cst438_project3_backend.entities.Story;
import com.groupsix.cst438_project3_backend.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  A controller to handle story related API endpoints
 */

@RestController
@RequestMapping(path = "/api")
public class StoryController {

    @Autowired
    StoryService storyService;

    @PostMapping(path = "/newstory")
    public ResponseEntity<Story> newStory(@RequestParam int userId, @RequestParam String storyName) {
        Story story = new Story(userId, storyName, null);
        storyService.saveStory(story);
        return ResponseEntity.ok(story);
    }

    @GetMapping(path = "/story", params = "storyId")
    public ResponseEntity<Story> getStoryById(@RequestParam int storyId) {
        Story story = storyService.findById(storyId);
        return ResponseEntity.ok(story);
    }

    @GetMapping(path = "/story", params = "userId")
    public ResponseEntity<Story> getStoryByUserId(@RequestParam int userId) {
        Story story = storyService.findByUserId(userId);
        return ResponseEntity.ok(story);
    }

    @GetMapping(path = "/story", params = "storyName")
    public ResponseEntity<Story> getStoryByName(@RequestParam String storyName) {
        Story story = storyService.findByName(storyName);
        return ResponseEntity.ok(story);
    }
}
