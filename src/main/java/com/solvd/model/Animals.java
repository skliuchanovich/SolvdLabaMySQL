package com.solvd.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Animals")
public class Animals {

    private List<Animal> animals;


    public List<Animal> getAnimals() {
        return animals;
    }

    @XmlElement(name = "Animal")
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
