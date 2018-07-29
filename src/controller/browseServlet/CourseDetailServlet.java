package controller.browseServlet;

import model.Chapter;
import model.Course;
import model.Point;
import model.User;
import service.ChapterService;
import service.CourseService;
import service.PointService;
import service.SelectionRecordService;
import service.serviceImpl.ChapterSerImpl;
import service.serviceImpl.CourseSerImpl;
import service.serviceImpl.PointSerImpl;
import service.serviceImpl.SelectionRecordSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/detail")
public class CourseDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseService courseService = new CourseSerImpl();
        ChapterService chapterService = new ChapterSerImpl();
        PointService pointService  = new PointSerImpl();
        SelectionRecordService selectionRecordService = new SelectionRecordSerImpl();

        String courseIdString = req.getParameter("courseid");
        if (courseIdString == null) {
            resp.sendRedirect("/home");
            return;
        }
        Integer courseId = Integer.parseInt(courseIdString);

        Course course = courseService.getCourseByCourseId(courseId);
        if (course == null) resp.sendRedirect("/home");

        //判断是否是该课学生或者未登录用户
        Boolean isStudent = false;
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && selectionRecordService.checkSelection(user.getUserId(), courseId))
            isStudent= true;

        //得到课程详情
        List<Chapter> chapters = chapterService.getChapters(courseId);
        Map<Integer, List<Point>> points = new HashMap<>();
        for (Chapter chapter : chapters){
            Integer chapterId = chapter.getChapterId();
            List<Point> pointList = pointService.getPoints(chapterId);
            points.put(chapterId, pointList);
        }

        req.setAttribute("isStudent", isStudent);
        req.setAttribute("course",course);
        req.setAttribute("chapters", chapters);
        req.setAttribute("points", points);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/detail.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
