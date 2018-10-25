package homework_JDBS.Task_2_with_search_history;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("File Search");
        primaryStage.setResizable(false);

        Parent parent = FXMLLoader.load(
                getClass().getResource("/jdbs/homework_JDBS/fileSearch.fxml")
        );
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}
