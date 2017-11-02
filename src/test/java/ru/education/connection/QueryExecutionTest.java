package ru.education.connection;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;

public class QueryExecutionTest {

    @Test
    public void QueryExecutionSimpleTest() {
        QueryExecution queryExecution = new QueryExecution();
        ResultSet resultSet = queryExecution.result("Topic");
        Assert.assertNotNull(resultSet);
    }
}
