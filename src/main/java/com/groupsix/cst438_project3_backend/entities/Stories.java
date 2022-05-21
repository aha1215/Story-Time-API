package com.groupsix.cst438_project3_backend.entities;

import javax.persistence.*;

@Entity
public class Stories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storiesId;
    private Integer userId;
    private String story;

    public Stories(Integer userId, String story) {
        this.userId = userId;
        this.story = story;
    }

    public Stories() {

    }

    public Integer getStoriesId() {
        return storiesId;
    }

    public void setStoriesId(Integer storiesId) {
        this.storiesId = storiesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}