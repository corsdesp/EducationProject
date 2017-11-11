package ru.education;

import ru.education.connection.ConnectionPool;
import ru.education.connection.QueryExecution;
import ru.education.entities.BaseEntity;
import ru.education.utils.printer.ConsolePrinter;
import ru.education.utils.printer.Printer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class App {
    private static final String PROPERTY = "postgreSql.properties";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(App.class.getResourceAsStream(PROPERTY));
        DataSource dataSource = ConnectionPool.getDataSource(properties);

        QueryExecution queryExecution = new QueryExecution(dataSource);
        List<BaseEntity> baseEntities = queryExecution.result();

        Printer printer = new ConsolePrinter();
        printer.print(baseEntities);
    }
}
