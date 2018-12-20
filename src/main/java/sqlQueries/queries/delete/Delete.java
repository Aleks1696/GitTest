package sqlQueries.queries.delete;

import sqlQueries.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    private static Connection connection = ConnectionUtil.getConnection();

    public static void delete1() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "DELETE FROM table_1 WHERE id = 2");
        statement.close();
    }

    public static void deleteAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "DELETE * FROM table_1");
        statement.close();
    }



}
