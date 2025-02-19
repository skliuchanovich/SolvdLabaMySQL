package com.solvd.decorator;

import com.solvd.model.Animal;

public class BasicAnimalDecorator implements IAnimalDecorator{
    protected IAnimalDecorator decorator;

    public BasicAnimalDecorator(IAnimalDecorator decorator) {
        this.decorator = decorator;
    }

    public BasicAnimalDecorator() {
    }

    @Override
    public void decorate(Animal animal) {
        if (decorator != null) {
            decorator.decorate(animal);
        }
    }
}
