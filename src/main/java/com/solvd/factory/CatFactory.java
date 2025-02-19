package com.solvd.factory;

import com.solvd.model.Animal;
import com.solvd.model.Cat;

public class CatFactory implements IAnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
