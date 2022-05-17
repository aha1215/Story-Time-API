package com.groupsix.cst438_project3_backend.repositories;

import com.groupsix.cst438_project3_backend.entities.StoryLikes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoryLikesRepository extends CrudRepository<StoryLikes, Integer> {
    StoryLikes findByStoryIdAndUserId(int storyId, int userId);

    List<StoryLikes> getAllByLikesIdIsNotNull();
}
