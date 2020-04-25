/* I18nMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.i18n;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * Basisversie van het programma. Gebruikt wel internationalisatie, maar geen FXML.
 */
public class I18nMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ResourceBundle bundle = ResourceBundle.getBundle("prog2/i18n/i18n");

        TextField textField = new TextField ();
        Button button = new Button(bundle.getString("buttonCaption"));

        HBox panel = new HBox ();
        panel.getStylesheets().add("prog2/i18n/i18n.css");
        panel.getChildren().addAll(
                new Label (bundle.getString("fieldLabel")),
                textField,
                button);
        
        stage.setScene(new Scene (panel));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch (args);
    }
    
}
