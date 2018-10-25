package homework_JDBS.Task_1_with_square_equation;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public class MainController {

    private static int countOfRoots = 0;
    private static boolean check = true;

    @FXML
    private TextField A_from;

    @FXML
    private TextField A_to;

    @FXML
    private TextField B_from;
    @FXML
    private TextField B_to;

    @FXML
    private TextField C_from;
    @FXML
    private TextField C_to;

    @FXML
    private TextField message;

    @FXML
    public void equationCalculation() {
        if (check) {
            InsertRootsToTable insert = new InsertRootsToTable();

            for (int a = Integer.parseInt(A_from.getText());
                 a <= Integer.parseInt(A_to.getText()); a++) {

                for (int b = Integer.parseInt(B_from.getText());
                     b <= Integer.parseInt(B_to.getText()); b++) {

                    for (int c = Integer.parseInt(C_from.getText());
                         c <= Integer.parseInt(C_to.getText()); c++) {

                        int d = (int) Math.pow(b, 2) - (4 * a * c);
                        if (d >= 0 & countOfRoots < 10000) {
                            Integer x1 = (int) ((-1) * b + Math.sqrt(d)) / (2 * a);
                            Integer x2 = (int) ((-1) * b - Math.sqrt(d)) / (2 * a);

                            insert.addRootsToTable(a, b, c, x1, x2);

                            countOfRoots++;
                        } else if (countOfRoots >= 10000) {

                            message.setText("too many roots (>10000)");
                            return;
                        }
                    }
                }
            }
            displayNumberOfRoots();
            check = false;
        } else {
            message.setText("Clear DB!");
        }
    }

    @FXML
    private void displayNumberOfRoots() {
        message.setText(Integer.toString(countOfRoots));
    }

    @FXML
    private void clearDB() {
        clearFields();

        Locale.setDefault(Locale.ENGLISH);

        String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
        String user = "myRoot";
        String pass = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM squareEquation"
            );
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        check = true;

        countOfRoots = 0;
        message.clear();

        A_from.clear();
        A_to.clear();

        B_from.clear();
        B_to.clear();

        C_from.clear();
        C_to.clear();
    }
}
