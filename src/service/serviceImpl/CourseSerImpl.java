package service.serviceImpl;

import dao.classDao.CourseDao;
import dao.classDao.UserDao;
import model.Course;
import service.CourseService;

import java.util.List;

public class CourseSerImpl implements CourseService {
    private CourseDao courseDao;
    private UserDao userDao;

    public CourseSerImpl(){
        courseDao = new CourseDao();
        userDao = new UserDao();
    }

    //通过用户id得到开课课程列表
    public List<Course> getCoursesByUserId(Integer userid){
        return courseDao.getCoursesByUserId(userid);
    }

    @Override
    public Course getCourseByCourseId(Integer courseId) {
        return courseDao.getCourseByCourseId(courseId);
    }

    //添加课程
    public boolean addCourse(Course course){
        if (!userDao.hasUserById(course.getUserId())) return false;
        else return courseDao.addCourse(course);
    }

    //删除课程
    public boolean removeCourse(Integer courseId){
        return courseDao.removeCourse(courseId);
    }

    //修改课程信息
    public boolean updateCourse(Course course){
        return courseDao.updateCourse(course);
    }

    //搜索
    //todo

}
