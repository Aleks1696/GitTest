package homework_JDBS.Task_2_with_search_history;

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

            statement.executeLargeUpdate("CREATE TABLE fileSearchHistory " +
                    "(File_request VARCHAR(50) NOT NULL," +
                    "File_path VARCHAR(300) NOT NULL," +
                    "Date VARCHAR(60))");
            statement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

