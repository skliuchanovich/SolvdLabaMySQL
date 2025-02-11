package com.solvd.dao;

import com.solvd.model.Cat;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICatDAO extends IBaseDAO<Cat>{
    @Select("SELECT * FROM mydb.cat WHERE id = #{id}")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="breed", column = "Breed"),
            @Result(property="animalID", column = "AnimalID")
    })
    @Override
    Cat getEntityByID(int id);

    @Select("SELECT * FROM mydb.cat")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="breed", column = "Breed"),
            @Result(property="animalID", column = "AnimalID")
    })
    @Override
    List<Cat> getEntities();

    @Insert("INSERT INTO mydb.cat (Breed, AnimalID) VALUES (#{breed}, #{animalID})")
    @Override
    void insert(Cat cat);

    @Update("UPDATE mydb.cat SET Breed = #{breed}, AnimalID = #{animalID} WHERE Id = #{id}")
    @Override
    void update(int id, Cat cat);

    @Delete("DELETE FROM mydb.cat WHERE Id = #{id}")
    @Override
    void delete(int id);
}
