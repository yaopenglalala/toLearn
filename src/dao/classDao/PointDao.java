package dao.classDao;

import dao.JDBCUtil;
import dao.daoInterface.JdbcDaoImpl;
import model.Chapter;
import model.Point;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class PointDao extends JdbcDaoImpl<Point> {
    private static Connection connection = JDBCUtil.getConnection();

    public PointDao(){
        init();
    }

    public boolean addPoint(Point point) {
        String sql = "INSERT INTO point_info (chapter_id, point_name) " +
                "values (?,?)";
        update(connection,sql,point.getChapterId(),point.getPointName());
        return true;
    }

    public boolean removePoint(Integer pointId){
        if (getPointByPointId(pointId) == null) return false;
        String sql = "DELETE FROM point_info where point_id = ?";
        update(connection,sql,pointId);
        return true;
    }

    public boolean updatePoint(Point point){
        if (getPointByPointId(point.getPointId()) == null) return false;
        String sql = "UPDATE point_info SET point_name=? where point_id = ?";
        update(connection,sql,point.getPointName(),point.getPointId());
        return true;
    }

    public Point getPointByPointId(Integer id){
        String sql = "SELECT point_id pointId, chapter_id chapterId, point_name pointName " +
                "FROM point_info where point_id = ?";
        return get(connection, sql, id);
    }

    public List<Point> getPointsByChapterId(Integer id){
        String sql = "SELECT point_id pointId, chapter_id chapterId, point_name pointName " +
                "FROM point_info where chapter_id = ?";
        return getList(connection, sql, id);
    }

    private static void init() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF not exists point_info (" +
                    "point_id INT UNSIGNED AUTO_INCREMENT, " +
                    "chapter_id INT NOT NULL, " +
                    "point_name VARCHAR(100), " +
                    "PRIMARY KEY (point_id)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
