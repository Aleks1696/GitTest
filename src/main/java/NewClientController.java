import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class NewClientController {

    @FXML
    private TextField fldNickName;
    @FXML
    private TextField fldEnteredText;

    @FXML
    private ListView<String> lstView;

    private ObservableList<String> observableList;

    private ClientModel client;

    @FXML
    private void initialize() {
        observableList = FXCollections.observableArrayList(new ArrayList<>());
        lstView.setItems(observableList);
    }


    public void setObservableList(String message) {
        observableList.setAll(message);
        lstView.refresh();
    }

    @FXML
    public void connectToServerOnClick(){
        client = new ClientModel(fldNickName.getText());
    }

    @FXML
    public void sendMessageFromClientOnClick(){
        client.write(fldEnteredText.getText());
        fldEnteredText.clear();
    }


}
