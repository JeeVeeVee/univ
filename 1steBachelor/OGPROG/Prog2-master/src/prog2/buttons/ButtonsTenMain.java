/* ButtonsTenMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.buttons;

import java.io.IOException;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Variant van {@link ButtonsNineMain} die een {@link ObservableIntegerValue}
 * gebruikt in plaats van een {@link PageModel}.
 */
public class ButtonsTenMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                ButtonsTenMain.class.getResource("ButtonsNine.fxml") // zelfde bestand als in versie negen!
                );
        IntegerProperty pageNumber = new SimpleIntegerProperty();
        loader.setController(new ButtonsTenCompanion(pageNumber));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
