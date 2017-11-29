package ru.education.servlets;

import ru.education.connection.ConnectionPool;
import ru.education.connection.PropertyInitializer;
import ru.education.service.StudentDaoImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.util.Properties;

public class Initializer implements ServletContextListener {
    private static final String PROPERTY = "postgreSql.properties";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        PropertyInitializer propertyInitializer = new PropertyInitializer();
        Properties prop = propertyInitializer.initialize(PROPERTY);

        DataSource dataSource = null;
        try {
            dataSource = ConnectionPool.getDataSource(prop);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        StudentDaoImpl studentService = new StudentDaoImpl(dataSource);
        servletContextEvent.getServletContext().setAttribute("studentService", studentService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
