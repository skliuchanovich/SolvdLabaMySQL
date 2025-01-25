package com.solvd.dao;

import com.solvd.model.Cat;

import java.util.List;

public interface ICatDAO extends IBaseDAO<Cat>{
    @Override
    Cat getEntityByID(int id);

    @Override
    List<Cat> getEntities();

    @Override
    void insert(Cat cat);

    @Override
    void update(int id, Cat cat);

    @Override
    void delete(int id);
}
