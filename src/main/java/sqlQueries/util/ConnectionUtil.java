package sqlQueries.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static String url = "jdbc:mysql://localhost:3306/sql_test?useSSL=false";
    private static String userName = "myRoot";
    private static String password = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, userName, password);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not connect to DB");
            return null;
        }
    }

}
