package service.serviceImpl;

import dao.classDao.TaskDao;
import model.Task;
import service.CourseService;
import service.TaskService;

import java.util.List;

public class TaskSerImpl implements TaskService {
    TaskDao taskDao;

    public TaskSerImpl(){
        taskDao = new TaskDao();
    }

    @Override
    public List<Task> getTasks(Integer courseId) {
        return taskDao.getTasksByCourseId(courseId);
    }

    @Override
    public Task getTask(Integer taskId) {
        return taskDao.getTaskByTaskId(taskId);
    }

    @Override
    public boolean addTask(Task task) {
        CourseService courseService = new CourseSerImpl();
        if (courseService.getCourseByCourseId(task.getCourseId()) == null) return false;
        else {
            return taskDao.addTask(task);
        }
    }

    @Override
    public boolean removeTask(Integer taskId) {
        return taskDao.removeTask(taskId);
    }

    @Override
    public boolean updateTask(Task task) {
        return taskDao.updateTask(task);
    }
}
