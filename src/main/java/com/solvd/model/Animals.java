package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Animals {

    @JsonProperty("Animal")
    private List<Animal> animals;

    public Animals() {
    }

    public Animals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "animals=" + animals +
                '}';
    }
}
