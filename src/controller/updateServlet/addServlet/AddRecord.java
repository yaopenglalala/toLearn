package controller.updateServlet.addServlet;

import model.User;
import service.SelectionRecordService;
import service.serviceImpl.SelectionRecordSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addRecord")
public class AddRecord extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        SelectionRecordService recordService = new SelectionRecordSerImpl();

        String courseIdString = req.getParameter("courseid");

        if ( courseIdString != null && ! courseIdString.equals("")){
            Integer courseId = Integer.parseInt(courseIdString);
            if (!recordService.checkSelection(user.getUserId(), courseId)){
                recordService.addRecord(user.getUserId(), courseId);
            }
        }
        resp.sendRedirect("/detail?courseid="+ courseIdString);
    }
}
