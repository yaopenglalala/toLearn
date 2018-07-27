package service;

import model.Course;
import model.User;

import java.util.List;

public interface SelectionRecordService {
    //选课
    boolean addRecord(Integer userId, Integer courseId);

    //退课
    boolean removeRecord(Integer userId, Integer courseId);

    //判断是否选课
    boolean checkSelection(Integer userId, Integer courseId);

    //得到用户选的课
    List<Course> getSelectedCourses(Integer userId);

    //得到选课名单
    List<User> getStudentList(Integer courseId);
}
