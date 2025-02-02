package com.solvd;

import com.solvd.model.Animal;
import com.solvd.model.Animals;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            JAXBContext context = JAXBContext.newInstance(Animals.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File xmlFile = new File("src/main/resources/animals.xml");
            Animals animalsWrapper = (Animals) unmarshaller.unmarshal(xmlFile);
            List<Animal> animals = animalsWrapper.getAnimals();
            animals.forEach(animal -> System.out.println(animal));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}
