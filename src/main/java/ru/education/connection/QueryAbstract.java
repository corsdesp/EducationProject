package ru.education.connection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class QueryAbstract {
    private DataSource ds;
    private Connection connection;
    private PreparedStatement stmt;

    QueryAbstract(DataSource ds) {
        this.ds = ds;
    }

    ResultSet getResultSet(String query) {
        try {
            connection = ds.getConnection();
            stmt = connection.prepareStatement(query);

            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void executeQuery(String query) {
        try {
            connection = ds.getConnection();
            stmt = connection.prepareStatement(query);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void simpleQuery(String query) {
        executeQuery(query);
        closeCon();
    }

    public void closeCon() {
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
