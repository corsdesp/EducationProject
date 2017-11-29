package ru.education.servlets;

import ru.education.entities.Student;
import ru.education.service.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {
    private StudentDaoImpl studentService;

    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commonParam(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first");
        String lastName = req.getParameter("second");

        studentService.save(new Student(studentList.size() + 1, firstName, lastName));

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
        studentService = (StudentDaoImpl) getServletContext().getAttribute("studentService");
    }
}
