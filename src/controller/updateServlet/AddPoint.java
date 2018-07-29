package controller.updateServlet;

import model.Point;
import model.User;
import service.ChapterService;
import service.PointService;
import service.serviceImpl.ChapterSerImpl;
import service.serviceImpl.PointSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPoint")
public class AddPoint extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
            return;
        }

        PointService pointService = new PointSerImpl();
        ChapterService chapterService = new ChapterSerImpl();

        String chapterIdString = req.getParameter("chapterid");
        String pointString = req.getParameter("point");

        if (chapterIdString != null && pointString != null){
            if (!chapterIdString.trim().equals("") && !pointString.trim().equals("")){
                Point point = new Point();
                point.setChapterId(Integer.parseInt(chapterIdString));
                point.setPointName(pointString);
                pointService.addPoint(point);
            }
        } else if (chapterIdString == null){
            resp.sendRedirect("/home");
            return;
        }
        resp.sendRedirect("/detail?courseid=" + chapterService.getChapter(Integer.parseInt(chapterIdString)).getCourseId());
    }
}
