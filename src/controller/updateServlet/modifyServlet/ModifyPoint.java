package controller.updateServlet.modifyServlet;

import model.Point;
import service.PointService;
import service.serviceImpl.PointSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ModifyPoint")
public class ModifyPoint extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PointService pointService = new PointSerImpl();
        String pointIdString = req.getParameter("pointid");
        try{
            Integer pointId = Integer.parseInt(pointIdString);
            String pointName = new String(req.getParameter("point").getBytes("ISO8859-1"),"UTF-8");

            Point point = new Point();

            point.setPointId(pointId);
            point.setPointName(pointName);
            point.setChapterId(pointService.getPoint(pointId).getChapterId());

            pointService.updatePoint(point);

        } catch (Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect("/point?pointid=" + pointIdString);
    }
}
