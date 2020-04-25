package Oefeningen.ContactsGUI.NieuwePersoon;

import Oefeningen.ContactsGUI.hoofdvenster.ControllerMain;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NieuwePersoon {


    public void start(Stage stage, ControllerMain controllerMain) throws Exception {
        ControllerNieuwePersoon controllerNieuwePersoon = new ControllerNieuwePersoon(controllerMain);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NieuwePersoon.fxml"));
        fxmlLoader.setController(controllerNieuwePersoon);
        stage.setScene(new Scene((Pane) fxmlLoader.load()));
        stage.show();
    }


}
