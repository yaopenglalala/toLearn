package service.serviceImpl;

import com.sun.org.apache.bcel.internal.generic.LREM;
import dao.classDao.CourseDao;
import dao.classDao.SelectionRecordDao;
import dao.classDao.UserDao;
import model.Chapter;
import model.Course;
import model.Point;
import service.CourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseSerImpl implements CourseService {
    private CourseDao courseDao;
    private UserDao userDao;
    private SelectionRecordDao selectionRecordDao;

    public CourseSerImpl(){
        courseDao = new CourseDao();
        userDao = new UserDao();
        selectionRecordDao = new SelectionRecordDao();
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

    @Override
    public List<Course> getHotCourses(int num) {
        List<Integer> courseIds = selectionRecordDao.getHotCourseIds(num);
        List<Course> rs = new ArrayList<>();
        for (Integer courseId : courseIds){
            rs.add(courseDao.getCourseByCourseId(courseId));
        }
        return rs;
    }

    @Override
    public List<Course> getNewCourses(int num) {
        return courseDao.getNewCourses(num);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    //搜索
    @Override
    public List<Course> searchCoursesByName(String name) {
        return courseDao.searchCoursesByName(name);
    }

    @Override
    public List<Course> searchCoursesByIntro(String introduction) {
        return courseDao.searchCoursesByIntro(introduction);
    }

}
