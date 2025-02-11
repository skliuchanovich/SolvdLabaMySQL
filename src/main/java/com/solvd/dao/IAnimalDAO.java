package com.solvd.dao;

import com.solvd.model.Animal;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAnimalDAO extends IBaseDAO<Animal>{

    @Select("SELECT * FROM mydb.animal WHERE id = #{id}")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="age", column = "Age"),
            @Result(property="name", column = "Name"),
            @Result(property="color", column = "Color"),
            @Result(property="birthDate", column = "Birth_Date"),

            @Result(property="health", column = "Health_Id",
                    one = @One(select = "com.solvd.dao.IHealthDAO.getEntityByID")),
            @Result(property="owner", column = "Owner_Id",
                    one = @One(select = "com.solvd.dao.IOwnerDAO.getEntityByID")),
            @Result(property="diet", column = "Diet_Id",
                    one = @One(select = "com.solvd.dao.IDietDAO.getEntityByID")),
            @Result(property="cat", column = "Cat_Id",
                    one = @One(select = "com.solvd.dao.ICatDAO.getEntityByID"))
    })
    Animal getEntityByID(int id);

    @Select("SELECT * FROM mydb.animal")
    @Results(value = {
            @Result(property="id", column = "Id"),
            @Result(property="age", column = "Age"),
            @Result(property="name", column = "Name"),
            @Result(property="color", column = "Color"),
            @Result(property="birthDate", column = "Birth_Date"),

            @Result(property="health", column = "Health_Id",
                    one = @One(select = "com.solvd.dao.IHealthDAO.getEntityByID")),
            @Result(property="owner", column = "Owner_Id",
                    one = @One(select = "com.solvd.dao.IOwnerDAO.getEntityByID")),
            @Result(property="diet", column = "Diet_Id",
                    one = @One(select = "com.solvd.dao.IDietDAO.getEntityByID")),
            @Result(property="cat", column = "Cat_Id",
                    one = @One(select = "com.solvd.dao.ICatDAO.getEntityByID"))
    })
    @Override
    List<Animal> getEntities();

    @Insert("INSERT INTO mydb.animal (Age, Name, Color, Birth_Date, Health_Id, Owner_Id, Diet_Id, Cat_Id) " +
            "VALUES (#{age}, #{name}, #{color}, #{birthDate}, #{health.id}, #{owner.id}, #{diet.id}, #{cat.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Override
    void insert(Animal animal);

    @Update("UPDATE mydb.animal SET Age = #{age}, Name = #{name}, Color = #{color}, Birth_Date = #{birthDate}, " +
            "Health_Id = #{health.id}, Owner_Id = #{owner.id}, Diet_Id = #{diet.id}, Cat_Id = #{cat.id} " +
            "WHERE Id = #{id}")
    @Override
    void update(int id, Animal animal);

    @Delete("DELETE FROM mydb.animal WHERE Id = #{id}")
    @Override
    void delete(int id);
}
