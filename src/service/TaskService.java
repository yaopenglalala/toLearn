package service;

import model.Chapter;
import model.Task;

import java.util.List;

public interface TaskService {
    //通过课程id得到作业列表
    List<Task> getTasks(Integer courseId);

    //通过作业id得到作业信息
    Task getTask(Integer taskId);

    //添加作业
    boolean addTask(Task task);

    //删除作业
    boolean removeTask(Integer taskId);

    //修改作业信息
    boolean updateTask(Task task);
}
