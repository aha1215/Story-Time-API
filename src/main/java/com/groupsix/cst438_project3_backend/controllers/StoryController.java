package com.groupsix.cst438_project3_backend.controllers;
import com.groupsix.cst438_project3_backend.entities.Stories;
import com.groupsix.cst438_project3_backend.entities.Story;
import com.groupsix.cst438_project3_backend.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/story?storyId={storyId}")
    public ResponseEntity<Story> getStoryById(@PathVariable int storyId) {
        Story story = storyService.findById(storyId);
        return ResponseEntity.ok(story);
    }

    @GetMapping(path = "/story?userId={userId}")
    public ResponseEntity<Story> getStoryByUserId(@PathVariable int userId) {
        Story story = storyService.findByUserId(userId);
        return ResponseEntity.ok(story);
    }

    @GetMapping(path = "/story?storyName={storyName}")
    public ResponseEntity<Story> getStoryByName(@PathVariable String storyName) {
        Story story = storyService.findByName(storyName);
        return ResponseEntity.ok(story);
    }
}
