package com.groupsix.cst438_project3_backend.service;

import com.groupsix.cst438_project3_backend.entities.Story;
import com.groupsix.cst438_project3_backend.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    StoryRepository storyRepository;

    public void saveStory(Story story) {
        storyRepository.save(story);
    }

    public Story updateStory(int userId, String storyName, Story story) {
        Story nStory = storyRepository.findStoryByUserIdAndStoryName(userId, storyName);

        if (nStory != null) {
            nStory.setStoryName(story.getStoryName());
            nStory.setStoryList(story.getStoryList());
            nStory.setOpen(story.getOpen());
            nStory.setLikes(story.getLikes());
            nStory.setDislikes(story.getDislikes());
            return storyRepository.save(nStory);
        }
        return null;
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

    public List<Story> getAllByUserId(int userId) { return storyRepository.getAllByUserId(userId); }

    public List<Story> getAllOpenStory() {
        return storyRepository.getAllByIsOpenTrue();
    }

    public List<Story> getAllClosedStory() {
        return storyRepository.getAllByIsOpenFalse();
    }

    public List<Story> getAll() {
        return storyRepository.getAllByStoryIdIsNotNull();
    }
}
