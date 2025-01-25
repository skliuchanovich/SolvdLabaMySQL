package com.solvd.dao;

import com.solvd.model.Animal;

import java.util.List;

public interface IAnimalDAO extends IBaseDAO<Animal>{
    @Override
    Animal getEntityByID(int id);

    @Override
    List<Animal> getEntities();

    @Override
    void insert(Animal animal);

    @Override
    void update(int id, Animal animal);

    @Override
    void delete(int id);
}
