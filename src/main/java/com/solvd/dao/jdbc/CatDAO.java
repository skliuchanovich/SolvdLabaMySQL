package com.solvd.dao.jdbc;

import com.solvd.dao.ICatDAO;
import com.solvd.model.Cat;
import com.solvd.utilities.BasicConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatDAO implements ICatDAO {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Cat getEntityByID(int id) {
        Cat cat = new Cat();
        String sql = "SELECT * FROM mydb.cat where ID = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cat.setBreed(resultSet.getString("breed"));
                cat.setAnimalID(resultSet.getInt("animal_id"));
            }

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return cat;
    }

    @Override
    public List<Cat> getEntities() {
        List<Cat> list = new ArrayList<>();
        String sql = "SELECT * FROM mydb.cat";
        Connection connection = connectionPool.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cat cat = new Cat();
                cat.setBreed(resultSet.getString("breed"));
                cat.setAnimalID(resultSet.getInt("animal_id"));
                list.add(cat);
            }

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);

        }

        return list;
    }

    @Override
    public void insert(Cat cat) {
        String sql = "INSERT INTO `mydb`.`cat`(`breed`) VALUES (?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cat.getBreed());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);

        }
    }

    @Override
    public void update(int id, Cat cat) {
        String sql = "UPDATE `mydb`.`cat` SET `breed` = ?  WHERE `id` = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cat.getBreed());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM `mydb`.`cat` WHERE `id` = ?";
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
