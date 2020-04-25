/* I18nFXMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.i18n;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Versie die gebruik maakt van internationalisatie binnen een FXML-bestand.
 */
public class I18nFXMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(
                     I18nFXMain.class.getResource("I18nFX.fxml"),
                     ResourceBundle.getBundle("prog2/i18n/i18n")
                );
        stage.setScene(new Scene (root));
        stage.show ();
    }
    
    public static void main(String[] args) {
        launch (args);
    }
    
}
