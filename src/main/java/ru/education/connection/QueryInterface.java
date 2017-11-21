package ru.education.connection;

import ru.education.entities.BaseEntity;
import ru.education.service.ResultReader;

import java.util.List;

public interface QueryInterface<T extends BaseEntity> {
    List<T> result (String query, ResultReader<T> resultReader);

    T oneResult (String query, ResultReader<T> resultReader);
}
