package controller.browseServlet;
//import com.alibaba.fastjson.JSONArray;
import model.Course;
import model.User;
import service.CourseService;
import service.SelectionRecordService;
import service.UserService;
import service.serviceImpl.CourseSerImpl;
import service.serviceImpl.SelectionRecordSerImpl;
import service.serviceImpl.UserSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private static final int numberPerPage = 6;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/json; charset=utf-8");
//        PrintWriter out = resp.getWriter();
//
//        String courseName = req.getParameter("name");
//        String introduction = req.getParameter("introduction");
//        String teacher = req.getParameter("teacher");
//        String order = req.getParameter("order");
//
//        CourseService courseService = new CourseSerImpl();
//
//        List<Course> courses = courseService.getCoursesByUserId(1);
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.addAll(courses);
//
//        out.print(jsonArray);
        String courseName = req.getParameter("coursename");
        String introduction = req.getParameter("introduction");
        String teacher = req.getParameter("teacher");
        String order = req.getParameter("order");
        String pageString = req.getParameter("page");

        //未输入页面信息
        if (pageString == null || pageString.equals("")) {
            String uri = req.getRequestURI();
            String queryString = req.getQueryString() == null ? "" : req.getQueryString() + "&&";
            String url = uri + "?" + queryString + "page=1";
            resp.sendRedirect(url);
            return;
        }

        List<Course> courses = getCourses(courseName, introduction, teacher);

        //热度升序
        if (order != null && order.equals("up")){
            courses.sort(numberUp());
        } else {
            //热度降序
            courses.sort(numberDown());
        }

        Integer page = Integer.parseInt(pageString);
        List<Course> result;
        Integer start = (page - 1) * numberPerPage;
        Integer end = page * numberPerPage;
        if (start < 0 || start >= courses.size()){
            start = 0;
            end = 0;
        } else if (end >= courses.size()){ ;
            end = courses.size();
        }

        result = courses.subList(start, end);

        Integer tag = courses.size() % numberPerPage == 0 ? 0 : 1;
        Integer numberOfPage = courses.size() / numberPerPage + tag;

        req.setAttribute("courses", result);
        //总页数
        req.setAttribute("numberOfPage", numberOfPage);

        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/search.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private List<Course> getCourses(String courseName, String introduction, String teacher){
        CourseService courseService = new CourseSerImpl();
        UserService userService = new UserSerImpl();

        //Get courses by name
        List<Course> nameCourseList = null;
        if (courseName != null && !courseName.equals("")) {
            System.out.println("name " + courseName);
            nameCourseList = courseService.searchCoursesByName(courseName);
        } else courseName = null;

        //Get courses by introduction
        List<Course> introCourseList = null;
        if (introduction != null && !introduction.equals("")){
            System.out.println("intro " + introduction);
            introCourseList  = courseService.searchCoursesByIntro(introduction);
        } else introduction = null;

        //Get courses by teacher
        List<User> userList;
        List<Course> teacherCourseList = new ArrayList<>();
        if (teacher != null && !teacher.equals("")){
            System.out.println("teacher " + teacher);
            userList = userService.searchUser(teacher);
            if (userList != null && userList.size() > 0){
                for (User user : userList){
                    teacherCourseList.addAll(courseService.getCoursesByUserId(user.getUserId()));
                }
            }
        } else teacher = null;

        //Get all courses
        if (courseName == null && introduction == null && teacher == null){
            System.out.println("here all");
            return courseService.getAllCourses();
        }

        //Get total course
        List<Course> courses = new ArrayList<>();
        if(nameCourseList != null) courses.addAll(nameCourseList);
        if (introCourseList != null) courses.addAll(introCourseList);
        courses.addAll(teacherCourseList);

        return courses;
    }

    private Comparator<Course> numberUp(){
        SelectionRecordService recordService = new SelectionRecordSerImpl();
        return (o1, o2) -> {
            if (recordService.getSelectNumber(o1.getCourseId()) >= recordService.getSelectNumber(o2.getCourseId())){
                return 1;
            } else return -1;
        };
    }

    private Comparator<Course> numberDown(){
        SelectionRecordService recordService = new SelectionRecordSerImpl();
        return (o1, o2) -> {
            if (recordService.getSelectNumber(o1.getCourseId()) >= recordService.getSelectNumber(o2.getCourseId())){
                return -1;
            } else return 1;
        };
    }
}
