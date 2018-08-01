package controller.updateServlet.addServlet;

import model.Task;
import model.User;
import service.TaskService;
import service.serviceImpl.TaskSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTask")
public class AddTask extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService taskService = new TaskSerImpl();

        String courseIdString = req.getParameter("courseid");
        String taskName = new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String taskDetail = new String(req.getParameter("detail").getBytes("ISO8859-1"),"UTF-8");

        if (courseIdString != null){
            if (!courseIdString.trim().equals("") && !taskName.trim().equals("")){
                Task task = new Task();
                task.setCourseId(Integer.parseInt(courseIdString));
                task.setTaskName(taskName);
                task.setTaskDetail(taskDetail);
                taskService.addTask(task);
            }
        }
        resp.sendRedirect("/task?courseid="+courseIdString);
    }
}
