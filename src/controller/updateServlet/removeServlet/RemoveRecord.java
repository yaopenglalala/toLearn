package controller.updateServlet.removeServlet;

import model.User;
import service.SelectionRecordService;
import service.serviceImpl.SelectionRecordSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeRecord")
public class RemoveRecord extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        try {
            Integer courseId = Integer.parseInt(req.getParameter("courseid"));

            SelectionRecordService recordService = new SelectionRecordSerImpl();

            recordService.removeRecord(user.getUserId(), courseId);
        } catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/myspace?type=select");
    }
}
