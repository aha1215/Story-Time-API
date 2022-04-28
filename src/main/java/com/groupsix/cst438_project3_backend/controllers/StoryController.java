package com.groupsix.cst438_project3_backend.controllers;

import com.google.gson.Gson;
import com.groupsix.cst438_project3_backend.entities.Stories;
import com.groupsix.cst438_project3_backend.entities.Story;
import com.groupsix.cst438_project3_backend.service.StoryService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<Story> newStory(@RequestParam int userId, @RequestParam String storyName, @RequestBody JSONObject[] jsonStories) {
        // Parse json object to list of stories using gson
        Gson gson = new Gson();
        List<Stories> storyList = new ArrayList<>();
        for (JSONObject json: jsonStories) {
            Stories stories = gson.fromJson(String.valueOf(json), Stories.class);
            storyList.add(stories);
        }
        Story story = new Story(userId, storyName, storyList);
        storyService.saveStory(story);
        return ResponseEntity.ok(story);
    }

    @GetMapping(path = "/story", params = "storyId")
    public ResponseEntity<Story> getStoryById(@RequestParam int storyId) {
        Story story = storyService.findById(storyId);
        return ResponseEntity.ok(story);
    }

    // Converted this to return all story belonging to user
    @GetMapping(path = "/story", params = "userId")
    public ResponseEntity<List<Story>> getAllStoryByUserId(@RequestParam int userId) {
        List<Story> storyList = storyService.getAllByUserId(userId);
        return ResponseEntity.ok(storyList);
    }

    @GetMapping(path = "/story", params = "storyName")
    public ResponseEntity<Story> getStoryByName(@RequestParam String storyName) {
        Story story = storyService.findByName(storyName);
        return ResponseEntity.ok(story);
    }
}
