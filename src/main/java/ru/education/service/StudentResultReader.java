package ru.education.service;

import ru.education.entities.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentResultReader implements ResultReader<Student> {
    @Override
    public Student read(ResultSet resultSet) {
        try {
            return new Student(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
        } catch (SQLException e) {

        }
        return null;
    }
}