package controller.browseServlet;

import model.Answer;
import model.Course;
import model.Task;
import model.User;
import service.AnswerService;
import service.CourseService;
import service.TaskService;
import service.serviceImpl.AnswerSerImpl;
import service.serviceImpl.CourseSerImpl;
import service.serviceImpl.TaskSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            User user = (User) req.getSession().getAttribute("user");
            Integer taskId = Integer.parseInt(req.getParameter("taskid"));

            CourseService courseService = new CourseSerImpl();
            TaskService taskService = new TaskSerImpl();
            AnswerService answerService = new AnswerSerImpl();

            Task task = taskService.getTask(taskId);
            Course course = courseService.getCourseByCourseId(task.getCourseId());
            Answer answer = answerService.getAnswer(user.getUserId(), taskId);

            req.setAttribute("course", course);
            req.setAttribute("task", task);
            req.setAttribute("answer", answer);

            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/answer.jsp");
            dispatcher.forward(req,resp);
        } catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("/home");
        }
    }
}
