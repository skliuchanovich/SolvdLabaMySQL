package com.solvd.decorator;

import com.solvd.model.Animal;

public class SoundDecorator extends BasicAnimalDecorator{
    public SoundDecorator(IAnimalDecorator decorator) {
        super(decorator);
    }


    public SoundDecorator() {
    }

    @Override
    public void decorate(Animal animal) {
        super.decorate(animal);
        System.out.println(animal.getClass().getSimpleName() + "\n" + "Meow");
    }
}
