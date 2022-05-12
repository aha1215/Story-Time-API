package com.groupsix.cst438_project3_backend.service;

import com.groupsix.cst438_project3_backend.entities.Comment;
import com.groupsix.cst438_project3_backend.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        Comment nComment = commentRepository.findCommentByCommentId(comment.getCommentId());

        if (nComment != null) {
            nComment.setComment(comment.getComment());
            return commentRepository.save(comment);
        }
        return null;
    }

    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    public Comment getCommentByStoryId(Integer storyId) {
        return commentRepository.findCommentByStoryId(storyId);
    }

    public Comment getCommentById(Integer commentId) {
        return commentRepository.findCommentByCommentId(commentId);
    }

    public Comment getCommentByUserId(Integer userId) {
        return commentRepository.findCommentByUserId(userId);
    }

    public Comment getCommentByStoryIdAndUserId(Integer storyId, Integer userId) {
        return commentRepository.findCommentByStoryIdAndUserId(storyId, userId);
    }
}
