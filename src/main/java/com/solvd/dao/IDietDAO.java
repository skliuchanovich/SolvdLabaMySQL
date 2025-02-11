package com.solvd.dao;

import com.solvd.model.Diet;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDietDAO extends IBaseDAO<Diet>{
    @Select("SELECT * FROM mydb.diet WHERE id = #{id}")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="feedingSchedule", column = "FeedingSchedule"),
            @Result(property="animalID", column = "AnimalID")
    })
    @Override
    Diet getEntityByID(int id);

    @Select("SELECT * FROM mydb.diet")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="feedingSchedule", column = "FeedingSchedule"),
            @Result(property="animalID", column = "AnimalID")
    })
    @Override
    List<Diet> getEntities();

    @Insert("INSERT INTO mydb.diet (FeedingSchedule, AnimalID) VALUES (#{feedingSchedule}, #{animalID})")
    @Override
    void insert(Diet diet);

    @Update("UPDATE mydb.diet SET FeedingSchedule = #{feedingSchedule}, AnimalID = #{animalID} WHERE Id = #{id}")
    @Override
    void update(int id, Diet diet);

    @Delete("DELETE FROM mydb.diet WHERE Id = #{id}")
    @Override
    void delete(int id);
}
