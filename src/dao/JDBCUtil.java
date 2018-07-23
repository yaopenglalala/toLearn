package dao;

import org.apache.commons.dbutils.DbUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
    private static Connection connection;

    public static Connection getConnection(){
        if (connection != null) return connection;

        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/dao/database.properties"));
            String JDBC_DRIVER = properties.getProperty("jdbcdriver");
            String DB_URL = properties.getProperty("dburl");
            String USER = properties.getProperty("user");
            String PASSWORD = properties.getProperty("password");

            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            return connection;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
