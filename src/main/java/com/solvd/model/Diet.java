package com.solvd.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Diet")
@XmlType(propOrder = {"id", "feedingSchedule", "animalID"})
public class Diet {

    private int id;
    private String feedingSchedule;
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

    @XmlElement(name = "Id")
    public void setId(int id) {
        this.id = id;
    }

    public String getFeedingSchedule() {
        return feedingSchedule;
    }

    @XmlElement(name = "FeedingSchedule")
    public void setFeedingSchedule(String feedingSchedule) {
        this.feedingSchedule = feedingSchedule;
    }

    public int getAnimalID() {
        return animalID;
    }

    @XmlElement(name = "AnimalID")
    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    @Override
    public String toString() {
        return "Diet{" + "id=" + id + ", feedingSchedule='" + feedingSchedule + '\'' + ", animalID=" + animalID + '}';
    }
}
