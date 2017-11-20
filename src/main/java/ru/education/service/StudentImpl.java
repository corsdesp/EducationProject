package ru.education.service;

import ru.education.connection.StudentQueryExecution;
import ru.education.dao.StudentDao;
import ru.education.entities.Student;

import javax.sql.DataSource;
import java.util.List;

public class StudentImpl implements StudentDao {
    private StudentQueryExecution queryExecution;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.queryExecution= new StudentQueryExecution(dataSource);
    }

    @Override
    public List<Student> findAll() {
        String query = "SELECT * FROM STUDENT";
        return queryExecution.result(query, new StudentResultReader());
    }

    @Override
    public Student findOne(long id) {
        String query = "SELECT * FROM STUDENT WHERE id=" + id;
        return queryExecution.oneResult(query, new StudentResultReader());
    }

    @Override
    public void remove(long id) {
        String query = "DELETE FROM STUDENT WHERE id=" + id;
        queryExecution.simpleQuery(query);
    }

    @Override
    public void save(Student val) {
        String query = "INSERT INTO STUDENT VALUES (" +
                val.getId() + ", '" +
                val.getFirstName() + "', '" +
                val.getLastName() + "')";
        queryExecution.simpleQuery(query);
    }
}
