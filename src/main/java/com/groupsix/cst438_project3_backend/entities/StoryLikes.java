package com.groupsix.cst438_project3_backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class for likes AND dislikes. Check if a user has liked or disliked a story. Only allow them to do this once.
 */

@Entity
public class StoryLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int likesId;
    int storyId;
    int userId;

    boolean isLiked;
    boolean isDisliked;

    public StoryLikes(int storyId, int userId, boolean isLiked, boolean isDisliked) {
        this.storyId = storyId;
        this.userId = userId;
        this.isLiked = isLiked;
        this.isDisliked = isDisliked;
    }

    public StoryLikes() {

    }

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isDisliked() {
        return isDisliked;
    }

    public void setDisliked(boolean disliked) {
        isDisliked = disliked;
    }
}
