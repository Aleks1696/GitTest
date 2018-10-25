package homework_JDBS.Task_2_with_search_history;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public class ClearDB {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
        String user = "myRoot";
        String pass = "root";

        try (Connection connection = DriverManager.getConnection(url, user, pass)){

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM fileSearchHistory"
            );
            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
