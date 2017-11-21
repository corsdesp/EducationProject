package ru.education.service;

import ru.education.connection.TopicQueryExecution;
import ru.education.dao.TopicDao;
import ru.education.entities.Topic;

import javax.sql.DataSource;
import java.util.List;

public class TopicDaoImpl implements TopicDao {
    private TopicQueryExecution queryExecution;

    public TopicDaoImpl(DataSource dataSource) {
        this.queryExecution = new TopicQueryExecution(dataSource);
    }

    @Override
    public List<Topic> findAll() {
        String query = "SELECT * FROM TOPIC";
        return queryExecution.result(query, new TopicResultReader());
    }

    @Override
    public Topic findOne(long id) {
        String query = "SELECT * FROM TOPIC WHERE id=" + id;
        return queryExecution.oneResult(query, new TopicResultReader());
    }

    @Override
    public void remove(long id) {
        String query = "DELETE FROM TOPIC WHERE id=" + id;
        queryExecution.simpleQuery(query);
    }

    @Override
    public void save(Topic val) {
        String query = "INSERT INTO TOPIC VALUES (" +
                val.getId() + ", '" +
                val.getName() + "')";
        queryExecution.simpleQuery(query);
    }
}
