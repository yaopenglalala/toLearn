package controller.browseServlet;

import controller.ControllerUtil;
import model.Course;
import model.User;
import service.CourseService;
import service.SelectionRecordService;
import service.serviceImpl.CourseSerImpl;
import service.serviceImpl.SelectionRecordSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/source")
public class SourceServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SelectionRecordService recordService = new SelectionRecordSerImpl();

        String courseIdString = req.getParameter("courseid");

        try {
            User user = (User) req.getSession().getAttribute("user");
            Integer courseId = Integer.parseInt(courseIdString);
            //是否登录
            if (user == null) resp.sendRedirect("/login");
            //是否选课
            else if (!recordService.checkSelection(user.getUserId(), courseId)){
                resp.sendRedirect("/detail?courseid=" + courseId);
            } else {
                String materialPath = "res/material/"+courseId+ "/";
                List<String> materials = new ArrayList<>();
                File[] files = ControllerUtil.getFilesByPath(materialPath);
                if (files.length > 0){
                    for (File file : files){
                        materials.add(materialPath + file.getName());
                    }
                }
                CourseService courseService = new CourseSerImpl();
                req.setAttribute("course", courseService.getCourseByCourseId(courseId));
                req.setAttribute("sources", materials);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/source.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (Exception e){
            resp.sendRedirect("detail/courseid="+courseIdString);
        }
    }
}
