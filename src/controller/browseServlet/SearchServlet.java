package controller.browseServlet;
import com.alibaba.fastjson.JSONArray;
import model.Course;
import service.CourseService;
import service.serviceImpl.CourseSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter out = resp.getWriter();

        String courseName = req.getParameter("name");
        String introduction = req.getParameter("introduction");
        String teacher = req.getParameter("teacher");
        String order = req.getParameter("order");

        CourseService courseService = new CourseSerImpl();

        List<Course> courses = courseService.getCoursesByUserId(1);
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(courses);

        out.print(jsonArray);
    }
}
