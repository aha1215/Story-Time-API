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

    public Stories findById(int storiesId) {
        return storiesRepository.findStoriesByStoriesId(storiesId);
    }

    public Stories findByUserId(int userId) {
        return storiesRepository.findStoriesByUserId(userId);
    }

    public List<Stories> getAllByUserId(int userId) {
        return storiesRepository.findAllByUserId(userId);
    }

}
