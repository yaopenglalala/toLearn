package controller.browseServlet;

import model.Chapter;
import model.Course;
import model.Point;
import service.ChapterService;
import service.PointService;
import service.serviceImpl.ChapterSerImpl;
import service.serviceImpl.PointSerImpl;

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

        Integer pointId = Integer.parseInt(req.getParameter("pointId"));

        Point point = pointService.getPoint(pointId);
        Course course = pointService.getCourseByPoint(point);

        List<Chapter> chapters = chapterService.getChapters(course.getCourseId());
        Map<Integer, List<Point>> points = new HashMap<>();
        for (Chapter chapter : chapters){
            Integer chapterId = chapter.getChapterId();
            List<Point> pointList = pointService.getPoints(chapterId);
            points.put(chapterId, pointList);
        }

        req.setAttribute("course",course);
        req.setAttribute("chapters", chapters);
        req.setAttribute("points", points);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/point.jsp");
        requestDispatcher.forward(req, resp);
    }
}
