package com.solvd.dao;

import com.solvd.model.Diet;

import java.util.List;

public interface IDietDAO extends IBaseDAO<Diet>{
    @Override
    Diet getEntityByID(int id);

    @Override
    List<Diet> getEntities();

    @Override
    void insert(Diet diet);

    @Override
    void update(int id, Diet diet);

    @Override
    void delete(int id);
}
