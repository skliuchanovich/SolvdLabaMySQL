package com.solvd.dao.jdbc;

import com.solvd.utilities.BasicConnectionPool;
import com.solvd.dao.IAnimalDAO;
import com.solvd.model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO implements IAnimalDAO {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Animal getEntityByID(int id) {
        Animal animal = new Animal();
        String sql = "SELECT * FROM mydb.animal where ID = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                animal.setName(resultSet.getString("name"));
                animal.setAge(resultSet.getInt("age"));
                animal.setColor(resultSet.getString("color"));
            }

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return animal;
    }

    @Override
    public List<Animal> getEntities() {
        List<Animal> list = new ArrayList<>();
        String sql = "SELECT * FROM mydb.animal";
        Connection connection = connectionPool.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Animal animal = new Animal();
                animal.setName(resultSet.getString("name"));
                animal.setAge(resultSet.getInt("age"));
                animal.setColor(resultSet.getString("color"));
                list.add(animal);
            }

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);

        }

        return list;
    }

    @Override
    public void insert(Animal animal) {
        String sql = "INSERT INTO `mydb`.`animal`(`name`,`color`,`age`) VALUES (?,?,?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getColor());
            preparedStatement.setInt(3, animal.getAge());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);

        }

    }

    @Override
    public void update(int id, Animal animal) {
        String sql = "UPDATE `mydb`.`animal` SET `name` = ?, `color` = ?, `age` = ?  WHERE `id` = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getColor());
            preparedStatement.setInt(3, animal.getAge());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM `mydb`.`animal` WHERE `id` = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
