package sqlQueries.queries.insert;

import sqlQueries.entity.Person;
import sqlQueries.util.ConnectionUtil;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Insert {

    private static Connection connection = ConnectionUtil.getConnection();

    public static void insert1() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO sql_test.table_1 (moto, name, weight, creationDate)" +
                        "VALUES ('Life if brilliant', 'Jack', 20.342523525223452, '2017-10-10')");
        statement.execute();
        connection.commit();
        statement.close();
    }

    public static void insertBatch() throws SQLException {

        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.addBatch(
                "INSERT INTO sql_test.table_1 (name, weight, moto, creationDate)" +
                        "VALUES ('James', 65.3, 'I''m here to change the world', '2017-8-20')"
        );
        statement.addBatch(
                "INSERT INTO sql_test.table_1 (name, weight, moto, creationDate)" +
                        "VALUES ('Christina', 50.3, 'I am pretty', '2015-9-2')"
        );
        statement.addBatch(
                "INSERT INTO sql_test.table_1 (name, weight, moto, creationDate) " +
                        "VALUES ('Emilie', 55.3, 'Be brave', '2012-3-22')"
        );
        statement.addBatch(
                "INSERT INTO sql_test.table_1 (name, moto, creationDate) " +
                        "VALUES ('Emilie', 'Appreciate every moment', '2018-11-26')"
        );
        int [] result = statement.executeBatch();
        connection.commit();
        statement.close();
    }

    public static void insertPerson() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO table_1 (name, weight, moto, creationDate)" +
                        "VALUES (?,?,?,?)"
        );
        Person person = new Person(
                999, "Rick", 98d, "No motoes", LocalDate.now());
        statement.setString(1, person.getName());
        statement.setDouble(2, person.getWeight());
        statement.setString(3, person.getMoto());
        statement.setDate(4, null);
        statement.execute();
        connection.commit();
        statement.close();
    }

    public static void insert() throws SQLException {
        PreparedStatement statementCustomer = connection.prepareStatement(
                "INSERT INTO customers (ID, Name, City, Age)" +
                        "VALUES (?,?,?,?)"
        );
        PreparedStatement statementOrder = connection.prepareStatement(
                "INSERT INTO orders (Name, Customer_ID, Amount)" +
                        "VALUES (?,?,?)"
        );
        statementCustomer.setInt(1, 1);
        statementCustomer.setString(2, "Nick");
        statementCustomer.setString(3, "New York");
        statementCustomer.setInt(4, 48);
        statementCustomer.execute();

        statementCustomer.setInt(1, 2);
        statementCustomer.setString(2, "Adam");
        statementCustomer.setString(3, "LA");
        statementCustomer.setInt(4, 28);
        statementCustomer.execute();

        statementCustomer.setInt(1, 3);
        statementCustomer.setString(2, "Cevin");
        statementCustomer.setString(3, "New York");
        statementCustomer.setInt(4, 25);
        statementCustomer.execute();

        statementCustomer.setInt(1, 4);
        statementCustomer.setString(2, "Julia");
        statementCustomer.setString(3, "Toronto");
        statementCustomer.setInt(4, 32);
        statementCustomer.execute();


        statementOrder.setString(1, "Smartphone");
        statementOrder.setInt(2, 1);
        statementOrder.setInt(3, 2);
        statementOrder.execute();

        statementOrder.setString(1, "MacBook");
        statementOrder.setInt(2, 4);
        statementOrder.setInt(3, 1);
        statementOrder.execute();

        statementOrder.setString(1, "SD card");
        statementOrder.setInt(2, 3);
        statementOrder.setInt(3, 5);
        statementOrder.execute();

        statementOrder.setString(1, "Dishes");
        statementOrder.setInt(2, 2);
        statementOrder.setInt(3, 34);
        statementOrder.execute();

        connection.commit();
        statementCustomer.close();
        statementOrder.close();
        connection.close();
    }

    //to join tables we use condition: WHERE customers.ID = orders.Customer_ID
    //it says "take ID and Name from customer table and take Name and Amount form orders
    //and then put it in our row"
    public static void insertCustomer_Order() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO customers_orders (Customer_ID, Customer_Name, Order_Name, Amount)" +
                        "VALUES (?, ?, ?, ?)"
        );
        ResultSet resultSet = connection.createStatement().executeQuery(
                "SELECT customers.ID, customers.Name, orders.Name, orders.Amount " +
                        "FROM customers, orders " +
                        "WHERE customers.ID = orders.Customer_ID " +
                        "ORDER BY customers.ID "
        );
        while (resultSet.next()){
            statement.setInt(1, resultSet.getInt("ID"));
            statement.setString(2, resultSet.getString("customers.Name"));
            statement.setString(3, resultSet.getString("orders.Name"));
            statement.setInt(4, resultSet.getInt("Amount"));
            statement.execute();
        }
        connection.commit();
        statement.close();
        resultSet.close();
        connection.close();
    }

}
