package dao;

import model.Course;
import model.User;
import service.CourseService;
import service.serviceImpl.CourseSerImpl;
import service.serviceImpl.UserSerImpl;

public class Jdbctest {
    public static void main(String[] args) {
        UserSerImpl userSerImpl = new UserSerImpl();
        userSerImpl.addUser("fsa", "ffsa");
        System.out.println(userSerImpl.checkUser("fsa","ffsa"));
        System.out.println(userSerImpl.removeUser(25));
        User user =  userSerImpl.getUser("fsa");
        user.setPassword("f123456");
        userSerImpl.updateUser(user);

        Course course = new Course();
        course.setUserId(1);
        course.setCourseName("fafsad");
        CourseService courseSer = new CourseSerImpl();
        courseSer.addCourse(course);
    }
}
