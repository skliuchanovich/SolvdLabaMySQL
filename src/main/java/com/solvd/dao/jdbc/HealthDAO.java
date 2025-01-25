package com.solvd.dao.jdbc;

import com.solvd.dao.IHealthDAO;
import com.solvd.model.Health;
import com.solvd.utilities.BasicConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HealthDAO implements IHealthDAO {
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();


    @Override
    public Health getEntityByID(int id) {
        Health health = new Health();
        String sql = "SELECT * FROM mydb.health where ID = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                health.setCheckUpDate(resultSet.getString("checkup_date"));
                health.setAnimalID(resultSet.getInt("Animal_id"));
                health.setHealthStatus(resultSet.getString("health_status"));
            }

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return health;
    }

    @Override
    public List<Health> getEntities() {
        List<Health> list = new ArrayList<>();
        String sql = "SELECT * FROM mydb.health";
        Connection connection = connectionPool.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Health health = new Health();
                health.setCheckUpDate(resultSet.getString("checkup_date"));
                health.setAnimalID(resultSet.getInt("Animal_id"));
                health.setHealthStatus(resultSet.getString("health_status"));
                list.add(health);
            }

        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);

        }

        return list;
    }

    @Override
    public void insert(Health health) {
        String sql = "INSERT INTO `mydb`.`health`(`checkup_date`, `health_status`, `Animal_id`) VALUES (?, ?, ?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, health.getCheckUpDate());
            preparedStatement.setString(2, health.getHealthStatus());
            preparedStatement.setInt(3, health.getAnimalID());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);

        }
    }

    @Override
    public void update(int id, Health health) {
        String sql = "UPDATE `mydb`.`health` SET `health_status` = ?  WHERE `id` = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, health.getHealthStatus());
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
        String sql = "DELETE FROM `mydb`.`health` WHERE `id` = ?";
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
