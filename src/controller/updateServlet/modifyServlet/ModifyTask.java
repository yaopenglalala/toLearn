package controller.updateServlet.modifyServlet;

import model.Answer;
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

@WebServlet("/modifyTask")
public class ModifyTask extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String taskIdString = req.getParameter("taskid");
        try{
            Integer taskId = Integer.parseInt(taskIdString);
            String taskName = req.getParameter("name");
            String taskDetail = req.getParameter("detail");

            TaskService taskService = new TaskSerImpl();

            Task task = taskService.getTask(taskId);
            task.setTaskName(taskName);
            task.setTaskDetail(taskDetail);

            taskService.updateTask(task);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/answer?taskid=" + taskIdString);
    }
}
