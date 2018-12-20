package sqlQueries;

import java.sql.*;
import java.util.Locale;

public class SQLCreateSchema {

    private static String url = "jdbc:mysql://localhost:3306?useSSL=false";
    private static String userName = "myRoot";
    private static String password = "root";

    public static void main(String[] args) throws SQLException {

        Locale.setDefault(Locale.ENGLISH);

        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement();
        statement.execute("CREATE SCHEMA sql_test");
        statement.close();

    }

}
