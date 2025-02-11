package com.solvd.dao;

import com.solvd.model.Owner;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface IOwnerDAO extends IBaseDAO<Owner> {
    @Select("SELECT * FROM mydb.owner WHERE id = #{id}")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="name", column = "Name"),
            @Result(property="contactInfo", column = "ContactInfo")
    })
    @Override
    Owner getEntityByID(int id);

    @Select("SELECT * FROM mydb.owner")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="name", column = "Name"),
            @Result(property="contactInfo", column = "ContactInfo")
    })
    @Override
    List<Owner> getEntities();

    @Insert("INSERT INTO mydb.owner (Name, ContactInfo) VALUES (#{name}, #{contactInfo})")
    @Override
    void insert(Owner owner);

    @Update("UPDATE mydb.owner SET Name = #{name}, ContactInfo = #{contactInfo} WHERE Id = #{id}")
    @Override
    void update(int id, Owner owner);

    @Delete("DELETE FROM mydb.owner WHERE Id = #{id}")
    @Override
    void delete(int id);
}
