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

    /**
     * Endpoint to create a new story
     * @param userId is the user id
     * @param storyName is the story name
     * @param jsonStories is a list of stories belonging to this story
     * @return response entity of created story
     */
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

    /**
     * Mark a story as open or closed.
     * @param storyId is the story id
     * @param isOpen true is open and false is closed
     * @return response entity of updated story
     */
    @PatchMapping(path = "/story/update", params = {"storyId", "isOpen"})
    public ResponseEntity<Story> updateStoryIsOpen(@RequestParam Integer storyId, @RequestParam boolean isOpen) {
        Story story = storyService.findById(storyId);
        if (story != null) {
            story.setIsOpen(isOpen);
            storyService.saveStory(story);
        }
        // It's not ok
        return ResponseEntity.ok(story);
    }

    /**
     * Update story likes
     * @param storyId is id
     * @param likes is number of likes a story has
     * @return response entity of updated story
     */
    @PatchMapping(path = "story/update", params = {"storyId", "likes"})
    public ResponseEntity<Story> updateStoryLikes(@RequestParam Integer storyId, @RequestParam int likes) {
        Story story = storyService.findById(storyId);
        if(story != null) {
            story.setLikes(likes);
            storyService.saveStory(story);
        }
        return ResponseEntity.ok(story);
    }

    /**
     * Update story dislikes
     * @param storyId is id
     * @param dislikes is number of likes a story has
     * @return response entity of updated story
     */
    @PatchMapping(path = "story/update", params = {"storyId", "dislikes"})
    public ResponseEntity<Story> updateStoryDislikes(@RequestParam Integer storyId, @RequestParam int dislikes) {
        Story story = storyService.findById(storyId);
        if(story != null) {
            story.setDislikes(dislikes);
            storyService.saveStory(story);
        }
        return ResponseEntity.ok(story);
    }

    /**
     * Get all story from database table
     * @return response entity of story list
     */
    @GetMapping(path = "/story/all")
    public ResponseEntity<List<Story>> getAllStory() {
        List<Story> storyList = storyService.getAll();
        return ResponseEntity.ok(storyList);
    }

    /**
     * Gets all open stories from story table
     * @return response entity story list
     */
    @GetMapping(path = "/story/allopen")
    public ResponseEntity<List<Story>> getAllOpenStory() {
        List<Story> storyList = storyService.getAllOpenStory();
        return ResponseEntity.ok(storyList);
    }

    /**
     * Gets all closed stories from story table
     * @return response entity story list
     */
    @GetMapping(path = "/story/allclosed")
    public ResponseEntity<List<Story>> getAllClosedStory() {
        List<Story> storyList = storyService.getAllClosedStory();
        return ResponseEntity.ok(storyList);
    }

    /**
     * Gets a story by its id
     * @param storyId is a story id
     * @return response entity story
     */
    @GetMapping(path = "/story", params = "storyId")
    public ResponseEntity<Story> getStoryById(@RequestParam int storyId) {
        Story story = storyService.findById(storyId);
        return ResponseEntity.ok(story);
    }

    /**
     * Get a list of stories from story table belonging to a user by their userId
     * @param userId is the userId of user to retrieve stories from
     * @return response entity story list
     */
    @GetMapping(path = "/story", params = "userId")
    public ResponseEntity<List<Story>> getAllStoryByUserId(@RequestParam int userId) {
        List<Story> storyList = storyService.getAllByUserId(userId);
        return ResponseEntity.ok(storyList);
    }

    /**
     * Get a story by its name
     * @param storyName the name of the story
     * @return response entity story
     */
    @GetMapping(path = "/story", params = "storyName")
    public ResponseEntity<Story> getStoryByName(@RequestParam String storyName) {
        Story story = storyService.findByName(storyName);
        return ResponseEntity.ok(story);
    }
}
