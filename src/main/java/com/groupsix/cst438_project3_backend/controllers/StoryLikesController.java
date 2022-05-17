package com.groupsix.cst438_project3_backend.controllers;

import com.groupsix.cst438_project3_backend.entities.Story;
import com.groupsix.cst438_project3_backend.entities.StoryLikes;
import com.groupsix.cst438_project3_backend.entities.User;
import com.groupsix.cst438_project3_backend.service.StoryLikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class StoryLikesController {
    @Autowired
    StoryLikesService storyLikesService;

    /**
     * Create new likes table entry showing if user liked or disliked a story.
     * @param storyId is id linking like or disliked to story
     * @param userId is id linking like or disliked to user
     * @param isLiked is story already liked
     * @param isDisliked is story already disliked
     * @return response entity story likes
     */
    @PostMapping(path="/likes/new")
    public ResponseEntity<StoryLikes> newLikesEntry(@RequestParam int storyId, @RequestParam int userId, @RequestParam boolean isLiked, @RequestParam boolean isDisliked) {
        StoryLikes storyLikes = new StoryLikes(storyId, userId, isLiked, isDisliked);
        storyLikesService.saveStoryLikes(storyLikes);
        return ResponseEntity.ok(storyLikes);
    }

    @PatchMapping(path = "likes/isliked", params = {"likesId", "isLiked"})
    public ResponseEntity<StoryLikes> updateStoryIsLiked(@RequestParam Integer likesId, @RequestParam boolean isLiked) {
        StoryLikes storyLikes = storyLikesService.getLikesById(likesId);
        if(storyLikes != null) {
            storyLikes.setLiked(isLiked);
            storyLikesService.saveStoryLikes(storyLikes);
        }
        return ResponseEntity.ok(storyLikes);
    }

    @PatchMapping(path = "likes/isdisliked", params = {"likesId", "isDisliked"})
    public ResponseEntity<StoryLikes> updateStoryIsDisliked(@RequestParam Integer likesId, @RequestParam boolean isDisliked) {
        StoryLikes storyLikes = storyLikesService.getLikesById(likesId);
        if(storyLikes != null) {
            storyLikes.setDisliked(isDisliked);
            storyLikesService.saveStoryLikes(storyLikes);
        }
        return ResponseEntity.ok(storyLikes);
    }

    /**
     * Retrieve a story by storyId and userId. Can be used to check if story is liked or disliked
     * @param storyId is id linking to story
     * @param userId is id linking to user
     * @return response entity story likes
     */
    @GetMapping(path = "/likes/check")
    public ResponseEntity<StoryLikes> getByStoryIdAndUserId(@RequestParam int storyId, @RequestParam int userId) {
        StoryLikes storyLikes = storyLikesService.getLikesByStoryIdAndUserId(storyId, userId);
        return ResponseEntity.ok(storyLikes);
    }

    /**
     * @return returns all like entries
     */
    @GetMapping(path = "/likes")
    public ResponseEntity<List<StoryLikes>> getAllLikes() {
        List<StoryLikes> storyLikesList = storyLikesService.getAll();
        return ResponseEntity.ok(storyLikesList);
    }
}
