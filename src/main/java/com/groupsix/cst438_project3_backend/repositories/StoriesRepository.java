package com.groupsix.cst438_project3_backend.repositories;

import com.groupsix.cst438_project3_backend.entities.Stories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoriesRepository extends CrudRepository<Stories, Integer> {
    Stories findStoriesByStoriesId(int storiesId);
    Stories findStoriesByUserId(int userId);
    List<Stories> findAllByUserId(int userId);
}
