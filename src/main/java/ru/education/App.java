package ru.education;

import ru.education.connection.ConnectionPool;
import ru.education.connection.PropertyInitializer;
import ru.education.entities.Student;
import ru.education.service.StudentImpl;
import ru.education.utils.printer.ConsolePrinter;
import ru.education.utils.printer.Printer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class App {
    private static final String PROPERTY = "postgreSql.properties";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PropertyInitializer propertyInitializer = new PropertyInitializer();
        Properties prop = propertyInitializer.initialize(PROPERTY);

        DataSource dataSource = ConnectionPool.getDataSource(prop);

        StudentImpl studentService = new StudentImpl(dataSource);
        List<Student> students = studentService.findAll();

        Printer<Student> printer = new ConsolePrinter();
        printer.print(students);
    }
}
