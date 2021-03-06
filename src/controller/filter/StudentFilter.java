package controller.filter;

import model.Course;
import model.User;
import service.*;
import service.serviceImpl.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/source","/task","/point","/answer"})
public class StudentFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        User user = (User) req.getSession().getAttribute("user");
        if (user == null || user.getUserId() == 0) {
            resp.sendRedirect("/login");
            return;
        } else {
            try {
                SelectionRecordService recordService = new SelectionRecordSerImpl();
                Integer courseId;
                String courseIdString = req.getParameter("courseid");
                String chapterIdString = req.getParameter("chapterid");
                String pointIdString = req.getParameter("pointid");
                String taskIdString = req.getParameter("taskid");
                if (courseIdString != null){
                    courseId = Integer.parseInt(courseIdString);
                } else if (chapterIdString != null) {
                    ChapterService chapterService = new ChapterSerImpl();
                    courseId = chapterService.getChapter(Integer.parseInt(chapterIdString)).getCourseId();
                } else if (pointIdString != null){
                    PointService pointService = new PointSerImpl();
                    ChapterService chapterService = new ChapterSerImpl();
                    Integer chapterId = pointService.getPoint(Integer.parseInt(pointIdString)).getChapterId();
                    courseId = chapterService.getChapter(chapterId).getCourseId();
                } else if (taskIdString != null){
                    TaskService taskService = new TaskSerImpl();
                    courseId = taskService.getTask(Integer.parseInt(taskIdString)).getCourseId();
                } else {
                    resp.sendRedirect("/home");
                    return;
                }

                CourseService courseService = new CourseSerImpl();
                if (!recordService.checkSelection(user.getUserId(),courseId)
                        && !courseService.getCourseByCourseId(courseId).getUserId().equals(user.getUserId())){
                    resp.sendRedirect("/detail?courseid=" + courseId);
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } catch (Exception e){
                e.printStackTrace();
                resp.sendRedirect("/home");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
