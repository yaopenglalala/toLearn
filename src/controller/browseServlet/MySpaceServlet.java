package controller.browseServlet;

import model.Course;
import model.User;
import service.CourseService;
import service.SelectionRecordService;
import service.serviceImpl.CourseSerImpl;
import service.serviceImpl.SelectionRecordSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myspace")
public class MySpaceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String type = req.getParameter("type");
        req.setAttribute("isSelected", false);
        List<Course> courses;
        if (type == null || !type.equals("open")){
            req.setAttribute("isSelected", true);
            courses = getSelectedCourses(user);
        } else courses = getOpenCourses(user);

        req.setAttribute("courses", courses);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/myspace.jsp");
        dispatcher.forward(req,resp);
    }

    private List<Course> getSelectedCourses(User user){
        SelectionRecordService recordService = new SelectionRecordSerImpl();
        return recordService.getSelectedCourses(user.getUserId());
    }

    private List<Course> getOpenCourses(User user){
        CourseService courseService = new CourseSerImpl();
        return courseService.getCoursesByUserId(user.getUserId());
    }
}
