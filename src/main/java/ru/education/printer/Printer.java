package ru.education.printer;

import ru.education.entities.BaseEntity;

import java.util.List;

public interface Printer {

    void print(List<BaseEntity> entities);
}
