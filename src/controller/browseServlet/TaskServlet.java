package controller.browseServlet;

import model.Course;
import model.Task;
import model.User;
import service.CourseService;
import service.SelectionRecordService;
import service.TaskService;
import service.serviceImpl.CourseSerImpl;
import service.serviceImpl.SelectionRecordSerImpl;
import service.serviceImpl.TaskSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService taskService = new TaskSerImpl();
        SelectionRecordService selectionRecordService = new SelectionRecordSerImpl();
        CourseService courseService = new CourseSerImpl();

        User user = (User) req.getSession().getAttribute("user");

        try {//可能会出现无courseid，courseid找不到对应课程
            Integer courseid = Integer.parseInt(req.getParameter("courseid"));
            Course course = courseService.getCourseByCourseId(courseid);
            if (! selectionRecordService.checkSelection(user.getUserId(), courseid) &&
                    ! course.getUserId().equals(user.getUserId())){
                resp.sendRedirect("/detail?courseid=" + courseid);
            } else {
                req.setAttribute("course", course);
                List<Task> tasks = taskService.getTasks(courseid);
                req.setAttribute("tasks", tasks);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/task.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (Exception e){
            resp.sendRedirect("/home");
        }
    }
}
