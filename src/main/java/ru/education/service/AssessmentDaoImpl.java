package ru.education.service;

import ru.education.connection.AssessmentQueryExecution;
import ru.education.dao.AssessmentDao;
import ru.education.entities.Assessment;

import javax.sql.DataSource;
import java.util.List;

public class AssessmentDaoImpl implements AssessmentDao {
    private AssessmentQueryExecution queryExecution;

    public AssessmentDaoImpl(DataSource dataSource) {
        this.queryExecution = new AssessmentQueryExecution(dataSource);
    }

    @Override
    public List<Assessment> findAll() {
        String query = "SELECT * FROM ASSESSMENT";
        return queryExecution.result(query, new AssessmentResultReader());
    }

    @Override
    public Assessment findOne(long id) {
        String query = "SELECT * FROM ASSESSMENT WHERE id=" + id;
        return queryExecution.oneResult(query, new AssessmentResultReader());
    }

    @Override
    public void remove(long id) {
        String query = "DELETE FROM ASSESSMENT WHERE id=" + id;
        queryExecution.simpleQuery(query);
    }

    @Override
    public void save(Assessment val) {
        String query = "INSERT INTO ASSESSMENT VALUES (" +
                val.getId() + ", '" +
                val.getName() + "')";
        queryExecution.simpleQuery(query);
    }
}
