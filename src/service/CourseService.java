package service;

import dao.classDao.CourseDao;
import dao.classDao.UserDao;
import model.Course;

import java.util.List;

public interface CourseService {

    //通过用户id得到开课课程列表
    List<Course> getCourses(Integer userid);

    //添加课程
    boolean addCourse(Course course);

    //删除课程
    boolean removeCourse(Integer courseId);

    //修改课程信息
    boolean updateCourse(Course course);

    //搜索
    //todo
}
