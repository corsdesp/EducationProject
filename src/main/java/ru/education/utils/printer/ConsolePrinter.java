package ru.education.utils.printer;

import ru.education.entities.BaseEntity;

import java.util.List;

public class ConsolePrinter implements Printer {

    public void print(List<BaseEntity> entities) {
        entities.stream().map(Object::toString).forEach(System.out::println);
    }
}
