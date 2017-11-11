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
    private DataSource ds;

    public QueryExecution(DataSource ds) {
        this.ds = ds;
    }

    public List<BaseEntity> result() {
        List<BaseEntity> baseEntities = new ArrayList<>();

        ResultSet resultSet = getResultSet();
        try {
            while (resultSet != null && resultSet.next()) {
                baseEntities.add(new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return baseEntities;
    }

    private ResultSet getResultSet() {
        try (Connection connection = ds.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Student");
             ResultSet resultSet = stmt.executeQuery()) {

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
