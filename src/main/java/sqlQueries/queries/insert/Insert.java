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

}
