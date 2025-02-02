package com.solvd.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Health")
@XmlType(propOrder = {"checkUpDate", "healthStatus", "animalID"})
public class Health {

    private String checkUpDate;
    private String healthStatus;
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

    @XmlElement(name = "CheckUpDate")
    public void setCheckUpDate(String checkUpDate) {
        this.checkUpDate = checkUpDate;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    @XmlElement(name = "HealthStatus")
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
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
        return "Health{" + ", checkUpDate='" + checkUpDate + '\'' + ", healthStatus='" + healthStatus + '\'' + ", animalID=" + animalID + '}';
    }
}
