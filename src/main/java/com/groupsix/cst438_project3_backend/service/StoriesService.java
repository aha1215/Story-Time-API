package com.groupsix.cst438_project3_backend.service;

import com.groupsix.cst438_project3_backend.entities.Stories;
import com.groupsix.cst438_project3_backend.repositories.StoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StoriesService {
    @Autowired
    StoriesRepository storiesRepository;

    public Stories findById(int storiesId) {
        return storiesRepository.findStoriesByStoriesId(storiesId);
    }

    public Stories findByUserId(int userId) {
        return storiesRepository.findStoriesByUserId(userId);
    }
}