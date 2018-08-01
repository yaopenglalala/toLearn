package controller.updateServlet.modifyServlet;

import model.Course;
import service.CourseService;
import service.serviceImpl.CourseSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyCourse")
public class ModifyCourse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseService courseService = new CourseSerImpl();
        String courseIdString = req.getParameter("courseid");

        try{
            Integer courseId = Integer.parseInt(courseIdString);
            String courseName = new String(req.getParameter("course_name").getBytes("ISO8859-1"),"UTF-8");
            String introduction = new String(req.getParameter("introduction").getBytes("ISO8859-1"),"UTF-8");

            Course course = courseService.getCourseByCourseId(courseId);
            course.setCourseName(courseName);
            course.setIntroduction(introduction);

            courseService.updateCourse(course);
        } catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/detail?courseid=" + courseIdString);
    }
}
