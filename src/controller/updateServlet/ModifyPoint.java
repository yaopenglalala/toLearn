package controller.updateServlet;

import model.Course;
import model.Point;
import model.User;
import service.PointService;
import service.serviceImpl.PointSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyPoint")
public class ModifyPoint extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        PointService pointService = new PointSerImpl();

        try {
            Integer pointId = Integer.parseInt(req.getParameter("pointid"));
            Course course = pointService.getCourseByPoint(pointService.getPoint(pointId));
            if (course.getUserId().equals(user.getUserId())){
                String name = req.getParameter("name");
                Point point = new Point();
                point.setPointId(pointId);
                point.setPointName(name);
                pointService.updatePoint(point);
            }
            resp.sendRedirect("/point?pointid=" + pointId);
        } catch (Exception e){
            resp.sendRedirect("/home");
        }
    }
}
