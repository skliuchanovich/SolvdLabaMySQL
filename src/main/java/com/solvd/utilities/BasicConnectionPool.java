package com.solvd.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BasicConnectionPool {

    private String url;
    private String user;
    private String password;
    private static List<Connection> connectionPool;
    private static List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 10;

    public static BasicConnectionPool create()  {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            try {
                connectionPool.add(createConnection(url, user, password));
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }
        return new BasicConnectionPool();
    }


    public Connection getConnection() {
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(
            String url, String user, String password)
            throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


}
