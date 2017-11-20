package ru.education.connection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class QueryAbstract {
    private DataSource ds;

    public QueryAbstract(DataSource ds) {
        this.ds = ds;
    }

    //при закрытии потоков в этом методе происходит ошибка ResultSet is closed
    public ResultSet getResultSet(String query) {
        try {
            Connection connection = ds.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = ds.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void simpleQuery(String query) {
        executeQuery(query);
    }
}
