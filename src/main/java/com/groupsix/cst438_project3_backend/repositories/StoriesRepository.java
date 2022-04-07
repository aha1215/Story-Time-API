package com.groupsix.cst438_project3_backend.repositories;

import com.groupsix.cst438_project3_backend.entities.Stories;
import org.springframework.data.repository.CrudRepository;

public interface StoriesRepository extends CrudRepository<Stories, Integer> {

    Stories findStoriesByStoriesId(int storiesId);
    Stories findStoriesByUserId(int userId);
}
