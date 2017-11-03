package ru.education.connection;

import ru.education.entities.BaseEntity;
import ru.education.entities.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryExecution {

    public List<BaseEntity> result() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<BaseEntity> baseEntities = new ArrayList<>();

        try {
            DataSource ds = ConnectionPool.setUp();
            connection = ds.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM Student");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                baseEntities.add(new Student(resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")));
            }
            return baseEntities;
        } catch (ClassNotFoundException | SQLException e) {
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
        return baseEntities;
    }
}
