package sqlQueries.queries.createTable;

import sqlQueries.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    private static Connection connection = ConnectionUtil.getConnection();

    public static void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE table_1 (" +
                "id int NOT NULL AUTO_INCREMENT UNIQUE ," +
                "name varchar (100), " +
                "weight double UNIQUE , " +
                "moto TEXT," +
                "creationDate date," +
                "PRIMARY KEY (id))");
        statement.close();
    }



}
