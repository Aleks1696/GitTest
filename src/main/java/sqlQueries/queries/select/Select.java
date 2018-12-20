package sqlQueries.queries.select;

import sqlQueries.entity.Person;
import sqlQueries.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Select {

    private static Connection connection = ConnectionUtil.getConnection();

    public static void select1() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM table_1 " +
                        "WHERE name='Kate'");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("weight"));
            System.out.println(resultSet.getString("moto"));
            System.out.println(resultSet.getDate("creationDate"));
        }
        statement.close();
    }

    public static void select2() throws SQLException {

        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet result = statement.executeQuery(
                "SELECT * FROM table_1 " +
                        "WHERE weight BETWEEN 50 AND 60"
        );
        while (result.next()){
            Person person = new Person();
            person.setId(result.getInt("id"));
            person.setName(result.getString("name"));
            person.setWeight(result.getDouble("weight"));
            person.setMoto(result.getString("moto"));
            person.setCreationDate(result.getDate(5).toLocalDate()); //by column number in the table

            System.out.println(person);
        }

        System.out.println("Result is closed? : " + result.isClosed());

        //moves cursor to the first row in resultSet
        result.first();
        //updates selected row on resultSet
        result.updateDouble("weight", (result.getDouble("weight")-20));
        //saves changes both to ResultSet and DB
        result.updateRow();
        //because autocommit = false was specified before
        connection.commit();
    }

    public static void select3() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT CONCAT(name, ',', weight) FROM table_1"
        );
        ResultSet result = statement.executeQuery();

        while (result.next()){
            System.out.println(result.getString(1));
        }
        statement.close();
    }

    public static void select4() throws SQLException {
        Statement statement = connection.prepareStatement(
                "SELECT UPPER(name) AS name, SQRT(weight) AS weight,  moto, creationDate FROM table_1 " +
                        "ORDER BY name ASC");
        ResultSet result = ((PreparedStatement) statement).executeQuery();
        while (result.next()){
            System.out.print(result.getString("name") + " - ");
            System.out.println(result.getDouble("weight"));
        }
        statement.close();
    }

    public static void select5() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT AVG(weight) FROM table_1 "
        );
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.println(result.getDouble(result.getRow()));
        }
        statement.close();
    }

    public static void select6() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM table_1 WHERE weight > " +
                        "(SELECT AVG(weight) FROM table_1)"
        );
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.print(result.getInt("id"));
            System.out.print(result.getString("name"));
            System.out.println(result.getDouble("weight"));
        }
        statement.close();
    }

    //symbol % is used to find elements that match the pattern. In this case all
    //elements starting with R will be selected. '%s' - all elem. ending with s
    //'_ _ C%' - matches only if C occurs at the third position
    //'[a-m]%[^aio] - begins with the letter a-m and NOT ends by a, i, o
    public static void select7() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM table_1 WHERE name LIKE 'R%'"
        );
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.print(result.getString("name"));
        }
        statement.close();
    }

    public static void select8() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT MIN(weight) AS min_weight FROM table_1"
        );
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.print(result.getString("min_weight"));
        }
        statement.close();
    }
}
