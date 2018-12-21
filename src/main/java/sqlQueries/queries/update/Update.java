package sqlQueries.queries.update;

import sqlQueries.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    private static Connection connection = ConnectionUtil.getConnection();

    public static void update1() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE table_1 " +
                        "SET weight = 22.3, name = 'Kate'" +
                        "WHERE id = 5");
        statement.execute();
        statement.getResultSet();       // resultSet can be obtained by calling this method
        statement.close();
        connection.close();
    }

    public static void update2() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE customers_dupl " +
                        "SET city = 'New Jersey'" +
                        "WHERE customers_dupl.name IN ('Mascha', 'Riki')");
        statement.execute();
        connection.commit();
        statement.close();
        connection.close();
    }




}
