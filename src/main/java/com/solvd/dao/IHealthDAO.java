package com.solvd.dao;

import com.solvd.model.Health;

import java.util.List;

public interface IHealthDAO extends IBaseDAO<Health>{
    @Override
    Health getEntityByID(int id);

    @Override
    List<Health> getEntities();

    @Override
    void insert(Health health);

    @Override
    void update(int id, Health health);

    @Override
    void delete(int id);
}
