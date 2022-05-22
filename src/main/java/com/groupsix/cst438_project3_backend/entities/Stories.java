package com.groupsix.cst438_project3_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Stories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storiesId;
    private Integer userId;
    private String story;

    @ManyToOne(targetEntity = Story.class)
    @JoinColumn(name = "story_id")
    @JsonBackReference
    private Story storyParent;

    public Stories(Integer userId, String story, Story storyParent) {
        this.userId = userId;
        this.story = story;
        this.storyParent = storyParent;
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

    public Story getStoryParent() {
        return storyParent;
    }

    public void setStoryParent(Story storyParent) {
        this.storyParent = storyParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stories stories = (Stories) o;
        return Objects.equals(storiesId, stories.storiesId) && Objects.equals(userId, stories.userId) && Objects.equals(story, stories.story) && Objects.equals(storyParent, stories.storyParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storiesId, userId, story, storyParent);
    }
}