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

    public static void createTable1() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE customers (" +
                "ID INT NOT NULL AUTO_INCREMENT," +
                "Name VARCHAR(255), " +
                "City VARCHAR(255), " +
                "Age INT," +
                "PRIMARY KEY (ID))"
        );
        statement.close();
    }

    public static void createTeble2() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE orders (" +
                        "ID INT NOT NULL AUTO_INCREMENT, " +
                        "Name VARCHAR(255)," +
                        "Customer_ID INT, " +
                        "Amount INT, " +
                        "PRIMARY KEY (ID))"
        );
        statement.close();
    }

    public static void createTabla3() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE customers_orders (" +
                        "Customer_ID INT NOT NULL, " +
                        "Customer_Name VARCHAR (255)," +
                        "Order_Name VARCHAR (255), " +
                        "Amount INT)"
        );
        statement.close();
        connection.close();
    }



}
