/* ButtonsNineMain.java
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Variant van {@link ButtonsTwoMain} die een {@link PageModel} gebruikt, met
 * de partnerklasse als enige view.<p> Bovendien worden model en partner-object
 * aangemaakt in het hoofdprogramma.
 */
public class ButtonsNineMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                ButtonsNineMain.class.getResource("ButtonsNine.fxml"));
        PageModel model = new PageModel();
        loader.setController(new ButtonsNineCompanion(model));
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
