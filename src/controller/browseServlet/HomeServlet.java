package controller.browseServlet;

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
import java.util.List;

@WebServlet("/home")
public class HomeServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseService courseService = new CourseSerImpl();
        List<Course> hotCourses = courseService.getHotCourses(3);
        List<Course> newCourses = courseService.getNewCourses(4);

        req.setAttribute("hotCourses", hotCourses);
        req.setAttribute("newCourses", newCourses);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/home.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
