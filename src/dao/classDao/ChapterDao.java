package dao.classDao;

import dao.JDBCUtil;
import dao.daoInterface.JdbcDaoImpl;
import model.Chapter;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class ChapterDao extends JdbcDaoImpl<Chapter> {
    private static Connection connection = JDBCUtil.getConnection();

    public ChapterDao(){
        init();
    }

    public boolean addChapter(Chapter chapter) {
        String sql = "INSERT INTO chapter_info (course_id, chapter_name) " +
                "values (?,?)";
        update(connection,sql,chapter.getCourseId(), chapter.getChapterName());
        return true;
    }

    public boolean removeChapter(Integer chapterId){
        if (getChapterByChapterId(chapterId) == null) return false;
        String sql = "DELETE FROM chapter_info where chapter_id = ?";
        update(connection,sql,chapterId);
        return true;
    }

    public boolean updateChapter(Chapter chapter){
        if (getChapterByChapterId(chapter.getChapterId()) == null) return false;
        String sql = "UPDATE chapter_info SET chapter_name=? where chapter_id = ?";
        update(connection,sql,chapter.getChapterName(),chapter.getChapterId());
        return true;
    }

    public Chapter getChapterByChapterId(Integer id){
        String sql = "SELECT chapter_id chapterId, course_id courseId, chapter_name chapterName " +
                "FROM chapter_info where chapter_id = ?";
        return get(connection, sql, id);
    }

    public List<Chapter> getChaptersByCourseId(Integer id){
        String sql = "SELECT chapter_id chapterId, course_id courseId, chapter_name chapterName " +
                "FROM chapter_info where course_id = ?";
        return getList(connection, sql, id);
    }

    private static void init() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF not exists chapter_info (" +
                    "chapter_id INT UNSIGNED AUTO_INCREMENT, " +
                    "course_id INT NOT NULL, " +
                    "chapter_name VARCHAR(100), " +
                    "PRIMARY KEY (chapter_id)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
