package com.solvd.dao.jdbc;

import com.solvd.dao.IOwnerDAO;
import com.solvd.model.Owner;
import com.solvd.utilities.BasicConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO implements IOwnerDAO {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Owner getEntityByID(int id) {
        Owner owner = new Owner();
        String sql = "SELECT * FROM mydb.owner WHERE id = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                owner.setName(resultSet.getString("name"));
                owner.setContactInfo(resultSet.getString("contact_info"));
            }
        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return owner;
    }

    @Override
    public List<Owner> getEntities() {
        List<Owner> list = new ArrayList<>();
        String sql = "SELECT * FROM mydb.owner";
        Connection connection = connectionPool.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Owner owner = new Owner();
                owner.setName(resultSet.getString("name"));
                owner.setContactInfo(resultSet.getString("contact_info"));
                list.add(owner);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return list;
    }

    @Override
    public void insert(Owner owner) {
        String sql = "INSERT INTO mydb.owner (name, contact_info) VALUES (?, ?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setString(2, owner.getContactInfo());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Owner owner) {
        String sql = "UPDATE mydb.owner SET name = ?, contact_info = ? WHERE id = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setString(2, owner.getContactInfo());
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
        String sql = "DELETE FROM mydb.owner WHERE id = ?";
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
