package com.solvd.factory;

public class FactoryProvider {
    public static IAnimalFactory getFactory(String type) {
        if ("Cat".equalsIgnoreCase(type)) {
            return new CatFactory();
        } else throw new IllegalArgumentException("Error");
    }
}