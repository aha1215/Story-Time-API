package com.groupsix.cst438_project3_backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storyId;
    private Integer userId;

    private String storyName;
    private Integer likes;
    private Integer dislikes;
    private Boolean open;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Stories.class, mappedBy = "story")
    @JsonManagedReference // https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
    private List<Stories> storyList;

    public Story(Integer userId, String storyName, List<Stories> storyList) {
        this.userId = userId;
        this.storyName = storyName;
        this.storyList = storyList;
        this.likes = 0;
        this.dislikes = 0;
        this.open = true;
    }

    public Story() {

    }

    public Boolean getIsOpen() {
        return open;
    }

    public void setIsOpen(Boolean open) {
        this.open = open;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(storyId, story.storyId) && Objects.equals(userId, story.userId) && Objects.equals(storyName, story.storyName) && Objects.equals(likes, story.likes) && Objects.equals(dislikes, story.dislikes) && Objects.equals(open, story.open) && Objects.equals(storyList, story.storyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storyId, userId, storyName, likes, dislikes, open, storyList);
    }
}