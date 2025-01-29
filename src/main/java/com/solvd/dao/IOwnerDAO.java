package com.solvd.dao;

import com.solvd.model.Owner;

import java.util.List;

public interface IOwnerDAO extends IBaseDAO<Owner> {
    @Override
    Owner getEntityByID(int id);

    @Override
    List<Owner> getEntities();

    @Override
    void insert(Owner owner);

    @Override
    void update(int id, Owner owner);

    @Override
    void delete(int id);
}
