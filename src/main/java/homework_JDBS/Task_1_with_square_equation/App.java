package homework_JDBS.Task_1_with_square_equation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("InsertRootsToTable");
        String path = "/jdbs/homework_JDBS/squareEquation.fxml";

        Parent parent = FXMLLoader.load(
                getClass().getResource(path)
        );
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}
