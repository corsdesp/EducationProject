package ru.education.connection;

import ru.education.entities.SummaryTable;
import ru.education.service.ResultReader;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SummaryTableQueryExecution extends QueryAbstract
        implements QueryInterface<SummaryTable> {

    public SummaryTableQueryExecution(DataSource ds) {
        super(ds);
    }

    @Override
    public List<SummaryTable> result(String query, ResultReader<SummaryTable> resultReader) {
        List<SummaryTable> summaryTables = new ArrayList<>();

        ResultSet resultSet = getResultSet(query);

        try {
            while (resultSet != null && resultSet.next()) {
                summaryTables.add(resultReader.read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return summaryTables;
    }

    @Override
    public SummaryTable oneResult(String query, ResultReader<SummaryTable> resultReader) {
        ResultSet resultSet = getResultSet(query);
        if (resultSet != null) {
            try {
                resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultReader.read(resultSet);
        }
        return new SummaryTable();
    }
}
