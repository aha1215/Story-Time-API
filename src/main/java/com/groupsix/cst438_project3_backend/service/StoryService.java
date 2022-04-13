package com.groupsix.cst438_project3_backend.service;

import com.groupsix.cst438_project3_backend.entities.Story;
import com.groupsix.cst438_project3_backend.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {

    @Autowired
    StoryRepository storyRepository;

    public void saveStory(Story story) {
        storyRepository.save(story);
    }

    public Story findById(int storyId) {
        return storyRepository.findStoryByStoryId(storyId);
    }

    public Story findByUserId(int userId) {
        return storyRepository.findStoryByUserId(userId);
    }

    public Story findByName(String storyName) {
        return storyRepository.findStoryByStoryName(storyName);
    }
}
