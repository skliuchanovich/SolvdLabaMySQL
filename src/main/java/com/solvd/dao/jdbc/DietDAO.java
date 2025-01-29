package com.solvd.dao.jdbc;

import com.solvd.dao.IDietDAO;
import com.solvd.model.Diet;
import com.solvd.utilities.BasicConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DietDAO implements IDietDAO {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Diet getEntityByID(int id) {
        Diet diet = new Diet();
        String sql = "SELECT * FROM mydb.diet WHERE id = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                diet.setFeedingSchedule(resultSet.getString("feeding_schedule"));
                diet.setAnimalID(resultSet.getInt("Animal_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return diet;
    }

    @Override
    public List<Diet> getEntities() {
        List<Diet> list = new ArrayList<>();
        String sql = "SELECT * FROM mydb.diet";
        Connection connection = connectionPool.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Diet diet = new Diet();
                diet.setFeedingSchedule(resultSet.getString("feeding_schedule"));
                diet.setAnimalID(resultSet.getInt("Animal_id"));
                list.add(diet);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return list;
    }

    @Override
    public void insert(Diet diet) {
        String sql = "INSERT INTO mydb.diet (feeding_schedule, Animal_id) VALUES (?, ?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diet.getFeedingSchedule());
            preparedStatement.setInt(2, diet.getAnimalID());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Diet diet) {
        String sql = "UPDATE mydb.diet SET feeding_schedule = ?, Animal_id = ? WHERE id = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diet.getFeedingSchedule());
            preparedStatement.setInt(2, diet.getAnimalID());
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM mydb.diet WHERE id = ?";
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
