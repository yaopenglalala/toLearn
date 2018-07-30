package controller.updateServlet.addServlet;

import controller.ControllerUtil;
import model.Course;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.CourseService;
import service.serviceImpl.CourseSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addCourse")
public class AddCourse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        CourseService courseService = new CourseSerImpl();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf8");

        Course course = new Course();
        try{
            //construct course
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem : fileItems){
                if (fileItem.isFormField()){
                    switch (fileItem.getFieldName()) {
                        case "course_name":
                            course.setCourseName(fileItem.getString("utf8"));
                            break;
                        case "introduction":
                            course.setIntroduction(fileItem.getString("utf8"));
                            break;
                    }
                }
            }
            course.setUserId(user.getUserId());

            //add course
            courseService.addCourse(course);
            //get course for course id
            List<Course> courseList = courseService.getCoursesByUserId(user.getUserId());
            course = courseList.get(courseList.size() - 1);
            for (FileItem fileItem : fileItems){
                if (!fileItem.isFormField()){
                    ControllerUtil.upLoadFile(fileItem, "res/course_img/" + course.getCourseId() + "/" , true);
                }
            }
            resp.sendRedirect("/detail?courseid="+course.getCourseId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
