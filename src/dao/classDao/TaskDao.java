package dao.classDao;

import dao.JDBCUtil;
import dao.daoInterface.JdbcDaoImpl;
import model.Chapter;
import model.Task;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class TaskDao extends JdbcDaoImpl<Task> {
    private static Connection connection = JDBCUtil.getConnection();

    public TaskDao(){
        init();
    }

    public boolean addTask(Task task) {
        String sql = "INSERT INTO task (course_id, task_name, task_detail) " +
                "values (?,?)";
        update(connection,sql,task.getCourseId(), task.getTaskName(), task.getTaskDetail());
        return true;
    }

    public boolean removeTask(Integer taskId){
        if (getTaskByTaskId(taskId) == null) return false;
        String sql = "DELETE FROM task where task_id = ?";
        update(connection,sql,taskId);
        return true;
    }

    public boolean updateTask(Task task){
        if (getTaskByTaskId(task.getTaskId()) == null) return false;
        String sql = "UPDATE task SET task_name=?, task_detail=? where task_id = ?";
        update(connection,sql,task.getTaskName(),task.getTaskDetail(),task.getTaskId());
        return true;
    }

    public Task getTaskByTaskId(Integer id){
        String sql = "SELECT task_id taskId, course_id courseId, task_name taskName, task_detail taskDetail " +
                "FROM task where task_id = ?";
        return get(connection, sql, id);
    }

    public List<Task> getTasksByCourseId(Integer id){
        String sql = "SELECT task_id taskId, course_id courseId, task_name taskName, task_detail taskDetail " +
                "FROM task where course_id = ?";
        return getList(connection, sql, id);
    }

    private static void init() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF not exists task (" +
                    "task_id INT UNSIGNED AUTO_INCREMENT, " +
                    "course_id INT NOT NULL, " +
                    "task_name VARCHAR(100), " +
                    "task_detail VARCHAR(1000)," +
                    "PRIMARY KEY (task_id)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
