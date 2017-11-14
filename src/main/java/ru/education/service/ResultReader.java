package ru.education.service;

import ru.education.entities.BaseEntity;

import java.sql.ResultSet;

public interface ResultReader<T extends BaseEntity> {

    T read(ResultSet resultSet);
}
