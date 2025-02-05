package com.solvd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.model.Animals;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            Animals animals = mapper.readValue(new File("src/main/resources/animals.json"), Animals.class);
            animals.getAnimals().forEach(animal -> System.out.println(animal));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
