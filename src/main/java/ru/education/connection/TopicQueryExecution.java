package ru.education.connection;

import ru.education.entities.Topic;
import ru.education.service.ResultReader;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicQueryExecution extends QueryAbstract implements QueryInterface<Topic> {

    public TopicQueryExecution(DataSource ds) {
        super(ds);
    }

    @Override
    public List<Topic> result(String query, ResultReader<Topic> resultReader) {
        List<Topic> topics = new ArrayList<>();

        ResultSet resultSet = getResultSet(query);

        try {
            while (resultSet != null && resultSet.next()) {
                topics.add(resultReader.read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topics;
    }

    @Override
    public Topic oneResult(String query, ResultReader<Topic> resultReader) {
        ResultSet resultSet = getResultSet(query);
        if (resultSet != null) {
            try {
                resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultReader.read(resultSet);
        }
        return new Topic();
    }
}
