package com.groupsix.cst438_project3_backend.repositories;

import com.groupsix.cst438_project3_backend.entities.Story;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoryRepository extends CrudRepository<Story, Integer> {
    Story findStoryByStoryId(int storyId);
    Story findStoryByUserId(int userId);
    Story findStoryByStoryName(String storyName);
    Story findStoryByUserIdAndStoryName(int userId, String storyName);

    List<Story> getAllByUserId(int userId);
}
