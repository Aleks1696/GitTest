package homework_JDBS.Task_1_with_square_equation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateTable {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
        String user = "myRoot";
        String pass = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            statement.executeLargeUpdate("CREATE TABLE squareEquation " +
                    "(A INTEGER NOT NULL, " +
                    "B INTEGER," +
                    "C INTEGER, " +
                    "1st_root INTEGER," +
                    "2nd_root INTEGER)");
            statement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
