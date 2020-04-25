package Oefeningen.ContactsGUI.ContactGegevens;

import Oefeningen.ContactsGUI.DatabankAccess.Person;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ContactGegevens {
    public void start(Stage stage, Person person) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContactGegevens.fxml"));
        fxmlLoader.setController(new ControllerContactGegevens(person));
        stage.setScene(new Scene((Pane) fxmlLoader.load()));
        stage.show();
    }
}
