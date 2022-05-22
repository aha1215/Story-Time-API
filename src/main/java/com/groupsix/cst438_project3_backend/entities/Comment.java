package com.groupsix.cst438_project3_backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private Integer storyId; // which story does it belong to?
    private Integer userId; // who made the comment?

    private String comment;

    public Comment(Integer storyId, Integer userId, String comment) {
        this.storyId = storyId;
        this.userId = userId;
        this.comment = comment;
    }

    public Comment() {

    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(commentId, comment1.commentId) && Objects.equals(storyId, comment1.storyId) && Objects.equals(userId, comment1.userId) && Objects.equals(comment, comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, storyId, userId, comment);
    }
}
