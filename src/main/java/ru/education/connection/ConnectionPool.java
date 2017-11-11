package ru.education.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class ConnectionPool {

    public static DataSource getDataSource(Properties properties) throws ClassNotFoundException {
        BasicDataSource basicDataSource = new BasicDataSource();
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
