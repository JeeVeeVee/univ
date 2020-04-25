package prog2.contacts.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ResourceBundle bundle = ResourceBundle.getBundle("prog2/contacts/gui/i18n");
        // We build the companion in advance, because this may generate a
        // database error

        PersonsCompanion companion;
        try {
            companion = new PersonsCompanion();
        } catch (Exception ex) {
            new ErrorAlert("initialization.error").showAndWait();
            Platform.exit();
            return; // keeps the compiler happy
        }

        // continue if there were no database errors
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Persons.fxml"), bundle);
        loader.setController(companion);
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setTitle(bundle.getString("main.title"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
