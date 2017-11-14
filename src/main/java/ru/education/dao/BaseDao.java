package ru.education.dao;

import java.util.List;

public interface BaseDao<T> {

    List<T> findAll();

    T findOne(long id);

    void remove(long id);

    void save(T val);
}
