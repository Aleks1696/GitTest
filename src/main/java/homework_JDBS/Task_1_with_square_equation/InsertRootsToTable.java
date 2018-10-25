package homework_JDBS.Task_1_with_square_equation;

import java.sql.*;
import java.util.Locale;

public class InsertRootsToTable {

    private String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
    private String user = "myRoot";
    private String pass = "root";

    public void addRootsToTable(Integer a, Integer b, Integer c,
                                Integer x1, Integer x2) {
        Locale.setDefault(Locale.ENGLISH);

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO squareEquation" +
                            "(A, B, C, 1st_root, 2nd_root)" +
                            "VALUES (?,?,?,?,?)"
            );

            statement.setInt(1, a);
            statement.setInt(2, b);
            statement.setInt(3, c);
            statement.setInt(4, x1);
            statement.setInt(5, x2);

            statement.execute();

            statement.clearParameters();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
