package com.solvd.dao;

import com.solvd.model.Health;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IHealthDAO extends IBaseDAO<Health> {

    @Select("SELECT * FROM mydb.health WHERE Id = #{id}")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="checkUpDate", column = "CheckUpDate"),
            @Result(property="healthStatus", column = "HealthStatus"),
            @Result(property="animalID", column = "AnimalID")
    })
    @Override
    Health getEntityByID(int id);

    @Select("SELECT * FROM mydb.health")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="checkUpDate", column = "CheckUpDate"),
            @Result(property="healthStatus", column = "HealthStatus"),
            @Result(property="animalID", column = "AnimalID")
    })
    @Override
    List<Health> getEntities();

    @Insert("INSERT INTO mydb.health (CheckUpDate, HealthStatus, AnimalID) VALUES (#{checkUpDate}, #{healthStatus}, #{animalID})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Override
    void insert(Health health);

    @Update("UPDATE mydb.health SET CheckUpDate=#{checkUpDate}, HealthStatus=#{healthStatus}, AnimalID=#{animalID} WHERE Id=#{id}")
    @Override
    void update(int id, Health health);

    @Delete("DELETE FROM mydb.health WHERE Id=#{id}")
    @Override
    void delete(int id);
}
