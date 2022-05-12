package com.groupsix.cst438_project3_backend.controllers;

import com.groupsix.cst438_project3_backend.entities.Comment;
import com.groupsix.cst438_project3_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping(path = "/comment", params = "storyId")
    public ResponseEntity<Comment> getCommentByStoryId(@RequestParam Integer storyId) {
        Comment comment = commentService.getCommentByStoryId(storyId);
        return ResponseEntity.ok(comment);
    }

    @GetMapping(path = "/comment", params = "commentId")
    public ResponseEntity<Comment> getCommentById(@RequestParam Integer commentId) {
        Comment comment = commentService.getCommentById(commentId);
        return ResponseEntity.ok(comment);
    }

    @GetMapping(path = "/comment", params = "userId")
    public ResponseEntity<Comment> getCommentByUserId(@RequestParam Integer userId) {
        Comment comment = commentService.getCommentByUserId(userId);
        return ResponseEntity.ok(comment);
    }

    @GetMapping(path = "/comment", params = {"storyId", "userId"})
    public ResponseEntity<Comment> getCommentByStoryIdAndUserId(@RequestParam Integer storyId, @RequestParam Integer userId) {
        Comment comment = commentService.getCommentByStoryIdAndUserId(storyId, userId);
        return ResponseEntity.ok(comment);
    }

    @PostMapping(path = "newcomment")
    public ResponseEntity<Comment> newComment(@RequestParam int storyId, @RequestParam int userId, @RequestParam String comment) {
        Comment comment1 = new Comment(storyId, userId, comment);
        commentService.saveComment(comment1);
        return ResponseEntity.ok(comment1);
    }

}
