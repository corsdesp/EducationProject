package ru.education.dao;

import java.util.List;

public interface BaseDao<T> {

    List<T> findAll();

    T findOne(long id);

    T remove(long id);

    T save(T val);
}
