package com.groupsix.cst438_project3_backend.service;

import com.groupsix.cst438_project3_backend.entities.StoryLikes;
import com.groupsix.cst438_project3_backend.repositories.StoryLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryLikesService {
    @Autowired
    StoryLikesRepository storyLikesRepository;

    public void saveStoryLikes(StoryLikes storyLikes) {
        storyLikesRepository.save(storyLikes);
    }

    public StoryLikes updateStoryLikes(int storyId, int userId, StoryLikes storyLikes) {
        StoryLikes nStoryLikes = storyLikesRepository.findByStoryIdAndUserId(storyId, userId);

        if (nStoryLikes != null) {
            nStoryLikes.setStoryId(storyLikes.getStoryId());
            nStoryLikes.setUserId(storyLikes.getUserId());
            nStoryLikes.setLiked(storyLikes.isLiked());
            nStoryLikes.setDisliked(storyLikes.isDisliked());
            return storyLikesRepository.save(nStoryLikes);
        }
        return null;
    }

    public StoryLikes getLikesByStoryIdAndUserId(int storyId, int userId) {
        return storyLikesRepository.findByStoryIdAndUserId(storyId, userId);
    }
}
