package ru.education.service;

import ru.education.entities.Assessment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssessmentResultReader implements ResultReader<Assessment> {
    @Override
    public Assessment read(ResultSet resultSet) {
        try {
            return new Assessment(
                    resultSet.getLong("id"),
                    resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
