package com.solvd;

import com.solvd.decorator.SoundDecorator;
import com.solvd.factory.FactoryProvider;
import com.solvd.factory.IAnimalFactory;
import com.solvd.model.Animal;

public class Main {

    public static void main(String[] args) {

        IAnimalFactory factory = FactoryProvider.getFactory("Cat");
        Animal cat = factory.createAnimal();
        SoundDecorator soundDecorator = new SoundDecorator();
        soundDecorator.decorate(cat);
        System.out.println(cat);
    }
}
