package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {

    @JsonProperty("Id")
    private int id;

    @JsonProperty("Breed")
    private String breed;

    @JsonProperty("AnimalID")
    private int animalID;

    public Cat() {
    }

    public Cat(int id, String breed, int animalID) {
        this.id = id;
        this.breed = breed;
        this.animalID = animalID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", animalID=" + animalID +
                '}';
    }
}
