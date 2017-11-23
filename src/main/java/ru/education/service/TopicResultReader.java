package ru.education.service;

import ru.education.entities.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicResultReader implements ResultReader<Topic> {
    @Override
    public Topic read(ResultSet resultSet) {
        try {
            return new Topic(
                    resultSet.getLong("id"),
                    resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
