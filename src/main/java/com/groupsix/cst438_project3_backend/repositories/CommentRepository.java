package com.groupsix.cst438_project3_backend.repositories;

import com.groupsix.cst438_project3_backend.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    Comment findCommentByStoryId(Integer storyId);
    Comment findCommentByCommentId(Integer commentId);
    Comment findCommentByUserId(Integer userId);
    Comment findCommentByStoryIdAndUserId(Integer storyId, Integer userId);
}
