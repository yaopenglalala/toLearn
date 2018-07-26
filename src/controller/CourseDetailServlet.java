package controller;

import model.Course;
import service.CourseService;
import service.serviceImpl.CourseSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class CourseDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseService courseService = new CourseSerImpl();
        Integer courseId = Integer.parseInt(req.getParameter("courseid"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/home.jsp");


        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
