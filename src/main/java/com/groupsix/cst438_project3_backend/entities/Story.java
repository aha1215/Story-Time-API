package com.groupsix.cst438_project3_backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storyId;
    private Integer userId;
    private String storyName;

    @OneToMany
    private List<Stories> storyList;

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public List<Stories> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Stories> storyList) {
        this.storyList = storyList;
    }
}