package com.groupsix.cst438_project3_backend.repositories;

import com.groupsix.cst438_project3_backend.entities.Story;
import org.springframework.data.repository.CrudRepository;

public interface StoryRepository extends CrudRepository<Story, Integer> {
    Story findStoryByStoryId(int storyId);
    Story findStoryByStoryName(String storyName);
}
