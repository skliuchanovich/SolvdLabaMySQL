package com.solvd.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Cat")
@XmlType(propOrder = {"breed", "animalID"})
public class Cat {

    private String breed;
    private int animalID;

    public Cat() {
    }

    public Cat(String breed, int animalID) {
        this.breed = breed;
        this.animalID = animalID;
    }

    public String getBreed() {
        return breed;
    }

    @XmlElement(name = "Breed")
    public void setBreed(String breed) {
        this.breed = breed;
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
        return "Cat{" + "breed='" + breed + '\'' + ", animalID=" + animalID + '}';
    }
}
