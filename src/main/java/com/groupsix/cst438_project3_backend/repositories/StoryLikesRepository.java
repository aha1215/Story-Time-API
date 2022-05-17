package com.groupsix.cst438_project3_backend.repositories;

import com.groupsix.cst438_project3_backend.entities.StoryLikes;
import org.springframework.data.repository.CrudRepository;

public interface StoryLikesRepository extends CrudRepository<StoryLikes, Integer> {
    StoryLikes findByStoryIdAndUserId(int storyId, int userId);
}
