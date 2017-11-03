package ru.education;

import ru.education.connection.QueryExecution;
import ru.education.entities.BaseEntity;
import ru.education.printer.ConsolePrinter;
import ru.education.printer.Printer;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {
        QueryExecution queryExecution = new QueryExecution();
        List<BaseEntity> baseEntities = queryExecution.result();

        Printer printer = new ConsolePrinter();
        printer.print(baseEntities);
    }
}
