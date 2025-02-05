package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Diet {

    @JsonProperty("Id")
    private int id;

    @JsonProperty("FeedingSchedule")
    private String feedingSchedule;

    @JsonProperty("AnimalID")
    private int animalID;

    public Diet() {
    }

    public Diet(int id, String feedingSchedule, int animalID) {
        this.id = id;
        this.feedingSchedule = feedingSchedule;
        this.animalID = animalID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedingSchedule() {
        return feedingSchedule;
    }

    public void setFeedingSchedule(String feedingSchedule) {
        this.feedingSchedule = feedingSchedule;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    @Override
    public String toString() {
        return "Diet{" +
                "id=" + id +
                ", feedingSchedule='" + feedingSchedule + '\'' +
                ", animalID=" + animalID +
                '}';
    }
}
