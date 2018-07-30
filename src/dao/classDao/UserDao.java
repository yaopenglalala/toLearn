package dao.classDao;

import dao.JDBCUtil;
import dao.daoInterface.JdbcDaoImpl;
import model.User;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class UserDao extends JdbcDaoImpl<User> {
    private static Connection connection = JDBCUtil.getConnection();

    public UserDao(){
        init();
    }

    public boolean addUser(User user) {
        if (hasUserByName(user.getUserName())) return false;
        String sql = "INSERT INTO user_info (user_name, password) " +
                "values (?,?)";
        update(connection,sql,user.getUserName(), user.getPassword());
        return true;
    }

    public boolean removeUser(Integer userid){
        if (!hasUserById(userid)) return false;
        String sql = "DELETE FROM user_info where user_id = ?";
        update(connection,sql,userid);
        return true;
    }

    public boolean updateUser(User user){
        if (!hasUserById(user.getUserId())) return false;
        String sql = "UPDATE user_info SET user_name=?, password=? where user_id = ?";
        update(connection,sql,user.getUserName(), user.getPassword(), user.getUserId());
        return true;
    }

    public User getUserByName(String name){
        String sql = "SELECT user_id userId, user_name userName, password FROM user_info where user_name = ?";
        return get(connection,sql,name);
    }

    public User getUserById(Integer id){
        String sql = "SELECT user_id userId, user_name userName, password FROM user_info where user_id = ?";
        return get(connection,sql,id);
    }

    public List<User> searchUser(String name){
        String sql = "SELECT user_id userId, user_name userName, password FROM user_info where user_name LIKE ?";
        return getList(connection,sql, "%"+ name + "%");
    }

    public boolean hasUserById(Integer id){
        return getUserById(id) != null;
    }

    public boolean hasUserByName(String name){
        return getUserByName(name) != null;
    }

    private static void init() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF not exists user_info (" +
                    "user_id INT UNSIGNED AUTO_INCREMENT, " +
                    "user_name VARCHAR(100) NOT NULL, " +
                    "password VARCHAR(100), " +
                    "PRIMARY KEY (user_id)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
