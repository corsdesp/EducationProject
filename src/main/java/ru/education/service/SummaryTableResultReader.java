package ru.education.service;

import ru.education.entities.SummaryTable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SummaryTableResultReader implements ResultReader<SummaryTable> {
    @Override
    public SummaryTable read(ResultSet resultSet) {
        try {
            return new SummaryTable(
                    resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getLong("topic_id"),
                    resultSet.getLong("assessment_id"),
                    resultSet.getString("value")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
