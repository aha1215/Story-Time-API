package com.groupsix.cst438_project3_backend.service;

import com.groupsix.cst438_project3_backend.entities.Stories;
import com.groupsix.cst438_project3_backend.repositories.StoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoriesService {

    @Autowired
    StoriesRepository storiesRepository;

    public void saveStories(Stories stories) {
        storiesRepository.save(stories);
    }

    public Stories updateStories(int userId, Stories stories) {
        Stories nStories = storiesRepository.findStoriesByUserId(userId);

        if (nStories != null) {
            nStories.setStory(stories.getStory());
            nStories.setUserId(stories.getUserId());
            return storiesRepository.save(nStories);
        }
        return null;
    }

    public void deleteStories(Stories stories) {
        storiesRepository.delete(stories);
    }

    public void deleteStories(List<Integer> storiesIdList) {
        storiesRepository.deleteAllById(storiesIdList);
    }

    public Stories findById(int storiesId) {
        return storiesRepository.findStoriesByStoriesId(storiesId);
    }

    public Stories findByUserId(int userId) {
        return storiesRepository.findStoriesByUserId(userId);
    }

    public List<Stories> findByUserIdAndStory(int userId, String story) { return storiesRepository.findStoriesByUserIdAndStory(userId, story); }

    public List<Stories> getAllByUserId(int userId) {
        return storiesRepository.findAllByUserId(userId);
    }

}
