package dao.classDao;

import dao.JDBCUtil;
import dao.daoInterface.JdbcDaoImpl;
import model.Course;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class CourseDao extends JdbcDaoImpl<Course> {
    private static Connection connection = JDBCUtil.getConnection();

    public CourseDao(){
        init();
    }

    public boolean addCourse(Course course) {
        String sql = "INSERT INTO course_info (user_id, course_name, introduction) " +
                "values (?,?,?)";
        update(connection,sql,course.getUserId(), course.getCourseName(), course.getIntroduction());
        return true;
    }

    public boolean removeCourse(Integer courseId){
        if (getCourseByCourseId(courseId) == null) return false;
        String sql = "DELETE FROM course_info where course_id = ?";
        update(connection,sql,courseId);
        return true;
    }

    public boolean updateCourse(Course course){
        if (getCourseByCourseId(course.getCourseId()) == null) return false;
        String sql = "UPDATE course_info SET user_id=?, course_name=? where course_id = ?";
        update(connection,sql,course.getUserId(),course.getCourseName(),course.getIntroduction(), course.getCourseId());
        return false;
    }

    public Course getCourseByCourseId(Integer id){
        String sql = "SELECT course_id courseId, user_id userId, course_name courseName, introduction " +
                "FROM course_info where course_id = ?";
        return get(connection, sql, id);
    }

    public List<Course> getCoursesByUserId(Integer id){
        String sql = "SELECT course_id courseId, user_id userId, course_name courseName, introduction " +
                "FROM course_info where user_id = ?";
        return getList(connection, sql, id);
    }

    private static void init() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF not exists course_info (" +
                    "course_id INT UNSIGNED AUTO_INCREMENT, " +
                    "user_id INT NOT NULL, " +
                    "course_name VARCHAR(100), " +
                    "introduction VARCHAR(2000), " +
                    "PRIMARY KEY (course_id)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
