package service.serviceImpl;

import dao.classDao.SelectionRecordDao;
import model.Course;
import model.SelectionRecord;
import model.User;
import service.CourseService;
import service.SelectionRecordService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class SelectionRecordSerImpl implements SelectionRecordService {
    private SelectionRecordDao selectionRecordDao;

    public SelectionRecordSerImpl(){
        selectionRecordDao = new SelectionRecordDao();
    }

    @Override
    public boolean addRecord(Integer userId, Integer courseId) {
        if (checkSelection(userId, courseId)) return false;
        else {
            SelectionRecord record = new SelectionRecord();
            record.setUserId(userId);
            record.setCourseId(courseId);
            selectionRecordDao.addRecord(record);
            return true;
        }
    }

    @Override
    public boolean removeRecord(Integer userId, Integer courseId) {
        if (!checkSelection(userId, courseId)) return false;
        else {
            SelectionRecord record = new SelectionRecord();
            record.setUserId(userId);
            record.setCourseId(courseId);
            selectionRecordDao.removeRecord(record);
            return true;
        }
    }

    @Override
    public boolean checkSelection(Integer userId, Integer courseId) {
        return selectionRecordDao.getRecordByUIdAndCId(userId, courseId) != null;
    }

    @Override
    public List<Course> getSelectedCourses(Integer userId) {
        List<SelectionRecord> recordList = selectionRecordDao.getRecordsByUid(userId);
        CourseService courseService = new CourseSerImpl();
        List<Course> rs = new ArrayList<>();
        for (SelectionRecord selectionRecord: recordList){
            rs.add(courseService.getCourseByCourseId(selectionRecord.getCourseId()));
        }
        return rs;
    }

    @Override
    public List<User> getStudentList(Integer courseId) {
        List<SelectionRecord> recordList = selectionRecordDao.getRecordsByCid(courseId);
        UserService userService = new UserSerImpl();
        List<User> rs = new ArrayList<>();
        for (SelectionRecord selectionRecord: recordList){
            rs.add(userService.getUserById(selectionRecord.getUserId()));
        }
        return rs;
    }

    @Override
    public Integer getSelectNumber(Integer courseId) {
        return selectionRecordDao.getNumberOfSelection(courseId);
    }
}
