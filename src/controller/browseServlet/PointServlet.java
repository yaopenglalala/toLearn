package controller.browseServlet;

import model.Chapter;
import model.Course;
import model.Point;
import model.User;
import service.ChapterService;
import service.PointService;
import service.SelectionRecordService;
import service.serviceImpl.ChapterSerImpl;
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

@WebServlet("/point")
public class PointServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChapterService chapterService = new ChapterSerImpl();
        PointService pointService  = new PointSerImpl();
        SelectionRecordService selectionRecordService = new SelectionRecordSerImpl();

        //得到课程
        Course course;
        Chapter chapter;
        Point point;
        try{
            Integer pointId = Integer.parseInt(req.getParameter("pointid"));
            point = pointService.getPoint(pointId);
            chapter = chapterService.getChapter(point.getChapterId());
            course = pointService.getCourseByPoint(point);
        } catch (Exception e){
            //e.printStackTrace();
            resp.sendRedirect("/home");
            return;
        }

        User user = (User) req.getSession().getAttribute("user");
        //是否登录
        if (user == null) resp.sendRedirect("/login");
        //是否选课
        else if (!selectionRecordService.checkSelection(user.getUserId(), course.getCourseId())){
            resp.sendRedirect("/detail?courseid=" + course.getCourseId());
        } else {
            //得到页面所需的内容
            List<Chapter> chapters = chapterService.getChapters(course.getCourseId());
            Map<Integer, List<Point>> points = new HashMap<>();
            for (Chapter chapter1 : chapters){
                Integer chapterId = chapter1.getChapterId();
                List<Point> pointList = pointService.getPoints(chapterId);
                points.put(chapterId, pointList);
            }
            List<String> videos = point.getVideoPathes();

            req.setAttribute("course",course);
            req.setAttribute("chapter", chapter);
            req.setAttribute("point", point);
            req.setAttribute("chapters", chapters);
            req.setAttribute("points", points);
            req.setAttribute("videos", videos);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/point.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
