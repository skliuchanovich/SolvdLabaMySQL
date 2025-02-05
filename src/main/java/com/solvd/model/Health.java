package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Health {

    @JsonProperty("Id")
    private int id;
    @JsonProperty("CheckUpDate")
    private String checkUpDate;

    @JsonProperty("HealthStatus")
    private String healthStatus;

    @JsonProperty("AnimalID")
    private int animalID;

    public Health() {
    }

    public Health(String checkUpDate, String healthStatus, int animalID) {
        this.checkUpDate = checkUpDate;
        this.healthStatus = healthStatus;
        this.animalID = animalID;
    }

    public String getCheckUpDate() {
        return checkUpDate;
    }

    public void setCheckUpDate(String checkUpDate) {
        this.checkUpDate = checkUpDate;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    @Override
    public String toString() {
        return "Health{" +
                "checkUpDate='" + checkUpDate + '\'' +
                ", healthStatus='" + healthStatus + '\'' +
                ", animalID=" + animalID +
                '}';
    }
}
