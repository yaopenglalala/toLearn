package dao.classDao;

import dao.JDBCUtil;
import dao.daoInterface.JdbcDaoImpl;
import model.Answer;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class AnswerDao extends JdbcDaoImpl<Answer> {
    private static Connection connection = JDBCUtil.getConnection();

    public AnswerDao(){
        init();
    }

    public boolean addAnswer(Answer answer) {
        if (getAnswerByUIdAndTId(answer.getUserId(), answer.getTaskId()) != null) return false;
        String sql = "INSERT INTO answer (user_id, task_id, answer_content) " +
                "values (?,?,?)";
        update(connection,sql,answer.getUserId(),answer.getTaskId(), answer.getAnswerContent());
        return true;
    }

    public boolean removeAnswer(Integer userId, Integer taskId){
        if (getAnswerByUIdAndTId(userId, taskId) == null) return false;
        String sql = "DELETE FROM answer where user_id = ? AND task_id = ?";
        update(connection, sql, userId, taskId);
        return true;
    }

    public boolean updateAnswer(Answer answer){
        String sql = "UPDATE answer SET answer_content = ? where answer_id = ?";
        update(connection,sql,answer.getAnswerContent(), answer.getAnswerId());
        return true;
    }

    public Answer getAnswerByAnswerId(Integer answerId){
        String sql = "SELECT answer_id answerId, user_id userId, task_id taskId, answer_content answerContent " +
                "FROM answer where answer_id = ? ";
        return get(connection, sql, answerId);
    }

    public Answer getAnswerByUIdAndTId(Integer uid, Integer tid){
        String sql = "SELECT answer_id answerId, user_id userId, task_id taskId, answer_content answerContent " +
                "FROM answer where user_id = ? AND task_id = ?";
        return get(connection, sql, uid, tid);
    }

    public List<Answer> getAnswersByUserId(Integer userId){
        String sql = "SELECT answer_id answerId, user_id userId, task_id taskId, answer_content answerContent " +
                "FROM answer where user_id = ? ";
        return getList(connection, sql, userId);
    }

    public List<Answer> getAnswersByTaskId(Integer taskId){
        String sql = "SELECT answer_id answerId, user_id userId, task_id taskId, answer_content answerContent " +
                "FROM answer where task_id = ? ";
        return getList(connection, sql, taskId);
    }

    private static void init() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF not exists answer (" +
                    "answer_id INT UNSIGNED AUTO_INCREMENT, " +
                    "user_id INT NOT NULL, " +
                    "task_id INT NOT NULL, " +
                    "answer_content varchar(5000)," +
                    "PRIMARY KEY (answer_id)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
