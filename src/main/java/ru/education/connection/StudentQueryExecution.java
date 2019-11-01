package ru.education.connection;

import ru.education.entities.Student;
import ru.education.service.ResultReader;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentQueryExecution extends QueryAbstract implements QueryInterface<Student> {

    public StudentQueryExecution(DataSource ds) {
        super(ds);
    }

    @Override
    public List<Student> result(String query, ResultReader<Student> resultReader) {
        List<Student> students = new ArrayList<>();

        ResultSet resultSet = getResultSet(query);
        try {
            while (resultSet != null && resultSet.next()) {
                students.add(resultReader.read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon();
        }
        return students;
    }

    @Override
    public Student oneResult(String query, ResultReader<Student> resultReader) {
        ResultSet resultSet = getResultSet(query);
        if (resultSet != null) {
            try {
                resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeCon();
            }
            return resultReader.read(resultSet);
        }
        return new Student();
    }
}
