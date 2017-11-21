package ru.education.servlets;

import ru.education.connection.ConnectionPool;
import ru.education.connection.PropertyInitializer;
import ru.education.entities.Student;
import ru.education.service.StudentImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainServlet extends HttpServlet {
    private static final String PROPERTY = "postgreSql.properties";
    private StudentImpl studentService;

    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commonParam(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first");
        String lastName = req.getParameter("second");

        studentService.save(new Student(studentList.size() + 1,firstName, lastName));

        commonParam(req, resp);
    }

    private void commonParam(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentList.clear();
        studentList = studentService.findAll();

        resp.setContentType("text/html");
        req.setAttribute("stud", "пользователей");
        req.setAttribute("list", studentList);
        req.getRequestDispatcher("student_page.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        PropertyInitializer propertyInitializer = new PropertyInitializer();
        Properties prop = propertyInitializer.initialize(PROPERTY);

        DataSource dataSource = null;
        try {
            dataSource = ConnectionPool.getDataSource(prop);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        studentService = new StudentImpl(dataSource);
    }
}
