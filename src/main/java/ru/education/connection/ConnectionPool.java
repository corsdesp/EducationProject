package ru.education.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPool {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/edu";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static DataSource setUp() throws ClassNotFoundException {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(DRIVER);
        basicDataSource.setUrl(URL);
        basicDataSource.setUsername(USERNAME);
        basicDataSource.setPassword(PASSWORD);

        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxOpenPreparedStatements(180);

        return basicDataSource;
    }
}
