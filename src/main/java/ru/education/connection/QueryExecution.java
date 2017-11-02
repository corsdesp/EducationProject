package ru.education.connection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecution {

    public ResultSet result(String dbName) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            DataSource ds = ConnectionPool.setUp();
            connection = ds.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM ?");
            stmt.setString(1, dbName);
            resultSet = stmt.executeQuery();
            return resultSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
