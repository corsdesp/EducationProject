package ru.education.connection;

import ru.education.entities.Assessment;
import ru.education.service.ResultReader;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssessmentQueryExecution extends QueryAbstract implements QueryInterface<Assessment> {

    public AssessmentQueryExecution(DataSource ds) {
        super(ds);
    }

    @Override
    public List<Assessment> result(String query, ResultReader<Assessment> resultReader) {
        List<Assessment> assessments = new ArrayList<>();

        ResultSet resultSet = getResultSet(query);

        try {
            while (resultSet != null && resultSet.next()) {
                assessments.add(resultReader.read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assessments;
    }

    @Override
    public Assessment oneResult(String query, ResultReader<Assessment> resultReader) {
        ResultSet resultSet = getResultSet(query);
        if (resultSet != null) {
            try {
                resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultReader.read(resultSet);
        }
        return new Assessment();
    }
}
