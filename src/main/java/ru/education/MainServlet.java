package ru.education;

import ru.education.entities.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {
    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentList.clear();
        studentList.add(new Student("one", "one"));
        studentList.add(new Student("two", "two"));
        studentList.add(new Student("three", "three"));

        resp.setContentType("text/html");

        req.setAttribute("stud", "пользователей");
        req.setAttribute("list", studentList);
        req.getRequestDispatcher("page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        req.setAttribute("stud", "пользователей");

        String firstName = req.getParameter("first");
        String lastName = req.getParameter("second");

        studentList.add(new Student(firstName, lastName));

        req.setAttribute("list", studentList);
        req.getRequestDispatcher("page.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
