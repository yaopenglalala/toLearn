package service;

import dao.classDao.CourseDao;
import dao.classDao.UserDao;
import model.Course;

import java.util.List;

public interface CourseService {

    //通过用户id得到开课课程列表
    List<Course> getCoursesByUserId(Integer userid);

    //通过课程id得到课程
    Course getCourseByCourseId(Integer courseId);

    //添加课程
    boolean addCourse(Course course);

    //删除课程
    boolean removeCourse(Integer courseId);

    //修改课程信息
    boolean updateCourse(Course course);

    //得到最热门课程
    List<Course> getHotCourses(int num);

    //得到最新课程
    List<Course> getNewCourses(int num);

    //得到所有课程
    List<Course> getAllCourses();

    //搜索
    List<Course> searchCoursesByName(String name);
    List<Course> searchCoursesByIntro(String introduction);
}
