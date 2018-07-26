package dao.classDao;

import com.sun.javafx.image.IntPixelGetter;
import dao.JDBCUtil;
import dao.daoInterface.JdbcDaoImpl;
import model.Point;
import model.SelectionRecord;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectionRecordDao extends JdbcDaoImpl<SelectionRecord> {
    private static Connection connection = JDBCUtil.getConnection();

    public SelectionRecordDao(){
        init();
    }

    public boolean addRecord(SelectionRecord selectionRecord) {
        String sql = "INSERT INTO selection_record (user_id, course_id) " +
                "values (?,?)";
        update(connection,sql,selectionRecord.getUserId(),selectionRecord.getCourseId());
        return true;
    }

    public boolean removeRecord(SelectionRecord selectionRecord){
        if (getRecordByUIdAndCId(selectionRecord.getUserId(), selectionRecord.getCourseId()) == null) return false;
        String sql = "DELETE FROM selection_record where user_id = ? AND course_id = ?";
        update(connection,sql,selectionRecord.getUserId(), selectionRecord.getCourseId());
        return true;
    }

    public SelectionRecord getRecordByRecordId(Integer id){
        String sql = "SELECT record_id recordId, user_id userId, course_id courseId " +
                "FROM selection_record where record_id = ?";
        return get(connection, sql, id);
    }

    public SelectionRecord getRecordByUIdAndCId(Integer uid, Integer cid){
        String sql = "SELECT record_id recordId, user_id userId, course_id courseId " +
                "FROM selection_record where user_id = ? AND course_id = ?";
        return get(connection, sql, uid, cid);
    }

    public List<SelectionRecord> getRecordsByUid(Integer uid){
        String sql = "SELECT record_id recordId, user_id userId, course_id courseId " +
                "FROM selection_record where user_id = ? ";
        return getList(connection, sql, uid);
    }

    public List<SelectionRecord> getRecordsByCid(Integer cid){
        String sql = "SELECT record_id recordId, user_id userId, course_id courseId " +
                "FROM selection_record where course_id = ? ";
        return getList(connection, sql, cid);
    }

    public List<Integer> getHotCourseIds(int num){
        String sql = "SELECT course_id , COUNT(*) as number " +
                "FROM selection_record GROUP BY course_id ORDER BY number DESC Limit ?";
        List<Map<String, Object>> list = getMap(connection, sql, num);
        List<Integer> rs = new ArrayList<>();
        if (list == null) {
            System.out.println("fdsafsda");
        }
        for (Map<String, Object> map : list){
            rs.add((Integer) map.get("course_id"));
        }
        return rs;
    }

    private static void init() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF not exists selection_record (" +
                    "record_id INT UNSIGNED AUTO_INCREMENT, " +
                    "user_id INT NOT NULL, " +
                    "course_id INT NOT NULL, " +
                    "PRIMARY KEY (record_id)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
