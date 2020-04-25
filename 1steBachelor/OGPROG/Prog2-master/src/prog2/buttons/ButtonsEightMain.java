/* ButtonsEightMain.java
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
 * Alternatief voor {@link ButtonsTwoMain}.<p>
 *
 * Analoog aan {@link ButtonsSevenMain} maar doet alle initialisatie in het
 * FXML-bestand, in plaats van de initialize-methode van de partnerklasse.
 */
public class ButtonsEightMain extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                ButtonsEightMain.class.getResource("ButtonsEight.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("");
        stage.show();
        
        // gewoon om te bewijzen dat we het model kunnen opvragen aan de partner
        ButtonsEightCompanion companion = loader.getController();
        System.out.println("Model = " + companion.model);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
