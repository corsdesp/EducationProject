package ru.education.utils.printer;

import ru.education.entities.Student;

import java.util.List;

public class ConsolePrinter implements Printer<Student> {

    @Override
    public void print(List<Student> entities) {
        entities.stream().map(Object::toString).forEach(System.out::println);
    }
}
