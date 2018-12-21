package sqlQueries.queries.alter;

import sqlQueries.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Alter {

    private static Connection connection = ConnectionUtil.getConnection();

    public static void alterAdd() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "ALTER TABLE customers_dupl ADD phoneNumber INT"
        );
        statement.close();
        connection.close();
    }

    public static void alterDrop() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "ALTER TABLE customers_dupl DROP COLUMN phoneNumber"
        );
        statement.close();
        connection.close();
    }

    public static void alterRenameTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "RENAME TABLE table_2 TO table_1"
        );
        statement.close();
        connection.close();
    }

    public static void alterRenameColumn() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "ALTER TABLE table_1 CHANGE creationDate creation_Date VARCHAR (255)"
        );
        statement.close();
        connection.close();
    }

}
