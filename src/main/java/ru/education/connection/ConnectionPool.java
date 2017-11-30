package ru.education.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class ConnectionPool {
    private static BasicDataSource basicDataSource;
    private static ConnectionPool instance;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            basicDataSource = new BasicDataSource();
            return new ConnectionPool();
        }
        return instance;
    }

    public DataSource generateDataSource(Properties properties) throws ClassNotFoundException {
        basicDataSource.setDriverClassName(properties.getProperty("driver"));
        basicDataSource.setUrl(properties.getProperty("url"));
        basicDataSource.setUsername(properties.getProperty("username"));
        basicDataSource.setPassword(properties.getProperty("password"));

        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxOpenPreparedStatements(180);

        return basicDataSource;
    }
}
