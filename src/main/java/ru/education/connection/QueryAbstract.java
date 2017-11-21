package ru.education.connection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class QueryAbstract {
    private DataSource ds;

    QueryAbstract(DataSource ds) {
        this.ds = ds;
    }

    //при закрытии потоков в этом методе происходит ошибка ResultSet is closed
    ResultSet getResultSet(String query) {
        try {
            Connection connection = ds.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void executeQuery(String query) {
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
