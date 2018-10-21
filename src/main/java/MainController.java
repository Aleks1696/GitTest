import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class MainController {

    @FXML
    private TextField fldCl1;
    @FXML
    private TextField fldCl2;
    @FXML
    private TextField fldCl3;
    @FXML
    private TextField fldCl4;
    @FXML
    private TextField fldCl5;
    @FXML
    private TextField fldCl6;
    @FXML
    private TextField fldCl7;
    @FXML
    private TextField fldCl8;
    @FXML
    private TextField fldCl9;
    @FXML
    private TextField fldCl10;

    @FXML
    private ListView lstView;


    @FXML
    public void startServerOnClick() {
        Server server = new Server();
    }

    @FXML
    public void addNewClientOnClick() {
        Server.signalToOpenNewPort = true;
        Stage dlgNewContact = new Stage();
        dlgNewContact.setTitle("Add contact");
        dlgNewContact.setResizable(false);
        try {
            dlgNewContact.setScene(new Scene(FXMLLoader.load(
                    getClass().getResource("/main/java/newClient.fxml")
            )));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dlgNewContact.showAndWait();
    }
}


