package homework_JDBS.Task_2_with_search_history;

import homework_JDBS.Task_2_with_search_history.model.FileModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Locale;

public class MainController {

    private static String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
    private static String user = "myRoot";
    private static String pass = "root";

    @FXML
    private TextField fldDirectory;
    @FXML
    private TextField fldFileName;

    @FXML
    private ListView lstFilesList;

    private ObservableList list;

    @FXML
    public void searchForFiles() {
        FileSearch fs = new FileSearch();
        FileModel.getFoundFiles().clear();
//        list = FXCollections.observableArrayList(ContactModel.getContacts());
        fs.search(fldDirectory.getText(), fldFileName.getText());

        list.setAll(FileModel.getFoundFiles());

        lstFilesList.setItems(list);
    }

    protected static void addResultToDB(String request, String path) {
        Locale.setDefault(Locale.ENGLISH);

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO fileSearchHistory " +
                            "(File_request, File_path, DateFormat)" +
                            "VALUES (?,?,?)");

            statement.setString(1, request);
            statement.setString(2, path);
            statement.setString(3, new SimpleDateFormat(
                    "yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));

            statement.execute();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
