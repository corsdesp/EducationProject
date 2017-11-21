package ru.education.service;

import ru.education.connection.SummaryTableQueryExecution;
import ru.education.dao.SummaryTableDao;
import ru.education.entities.SummaryTable;

import javax.sql.DataSource;
import java.util.List;

public class SummaryTableDaoImpl implements SummaryTableDao {
    private SummaryTableQueryExecution queryExecution;

    public SummaryTableDaoImpl(DataSource dataSource) {
        this.queryExecution = new SummaryTableQueryExecution(dataSource);
    }

    @Override
    public List<SummaryTable> findAll() {
        String query = "SELECT * FROM SUMMARY_TABLE";
        return queryExecution.result(query, new SummaryTableResultReader());
    }

    @Override
    public SummaryTable findOne(long id) {
        String query = "SELECT * FROM SUMMARY_TABLE WHERE id=" + id;
        return queryExecution.oneResult(query, new SummaryTableResultReader());
    }

    @Override
    public void remove(long id) {
        String query = "DELETE FROM SUMMARY_TABLE WHERE id=" + id;
        queryExecution.simpleQuery(query);
    }

    @Override
    public void save(SummaryTable val) {
        String query = "INSERT INTO SUMMARY_TABLE VALUES (" +
                val.getId() + ", " +
                val.getStudentId() + ", " +
                val.getTopicId() + ", " +
                val.getAssessmentId() + ", '" +
                val.getValue() + "')";
        queryExecution.simpleQuery(query);
    }
}
