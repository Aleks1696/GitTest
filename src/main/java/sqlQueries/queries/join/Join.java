package sqlQueries.queries.join;

import sqlQueries.util.ConnectionUtil;

import java.sql.*;

public class Join {

    public static Connection connection = ConnectionUtil.getConnection();

    public static void joinWithWhereCondition() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
            "SELECT ct.ID, ct.Name, ord.Name, ord.Amount " +
                    "FROM customers AS ct, orders AS ord " +
                    "WHERE ct.ID = ord.Customer_ID " +
                    "ORDER BY ct.ID"
        );
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.print(result.getInt("ID") + " ");
            System.out.print(result.getString("Name") + " ");
            System.out.print(result.getString(3) + " ");
            System.out.println(result.getString(4));
        }
    }

    //result is the same as with WHERE (above method)
    public static void innerJoin() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT customers.ID, customers.Name, orders.Name " +
                        "FROM customers INNER JOIN orders " +
                        "ON customers.ID = orders.Customer_ID " +
                        "ORDER BY customers.ID"
        );
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.print(result.getInt("ID") + " ");
            System.out.print(result.getString("Name") + " ");
            System.out.println(result.getString(3) + " ");
        }
    }

    public static void rightJoin() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT ct.ID, ct.Name, ord.Name, ord.Amount " +
                        "FROM (customers AS ct) RIGHT OUTER JOIN (orders AS ord) " +
                        "ON ct.ID = ord.Customer_ID " +
                        "ORDER BY ord.ID "
        );
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.print(result.getString(1) + " ");
            System.out.print(result.getString(2) + " ");
            System.out.print(result.getString(3) + " ");
            System.out.println(result.getString(4));
        }
    }

    public static void leftJoin() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT customers.Name, orders.Name " +
                        "FROM customers LEFT JOIN orders " +
                        "ON customers.ID = orders.Customer_ID " +
                        "ORDER BY customers.ID"
        );
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.print(result.getString(1) + " ");
            System.out.println(result.getString(2) + " ");
        }
    }

    //UNION stores all unique rows / UNION ALL stores all values, even duplicates
    //To union table both tables should have same number of columns and their data types!
    public static void union() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT ct.ID, ct.Name FROM (customers AS ct) " +
                        "UNION " +
                        "SELECT ord.ID, ord.Name FROM (orders AS ord)"
        );
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            System.out.print(result.getString(1) + " ");
            System.out.println(result.getString(2));
        }

    }
}

