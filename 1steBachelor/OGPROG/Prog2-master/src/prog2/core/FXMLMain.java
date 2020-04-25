/* FXMLMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.core;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Gemeenschappelijke hoofdklasse voor programma's die volledig zijn
 * gespecifieerd door een FXML-bestand.
 */
public class FXMLMain extends Application {

    /**
     * Geeft de naam terug van het FXML-bestand waarop deze toepassing is
     * gebaseerd.
     */
    protected String getFXMLResourceName() {
        String className = getClass().getSimpleName();
        if (className.endsWith("Main")) {
            className = className.substring(0, className.length() - 4);
        }
        return className + ".fxml";
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().
                getResource(getFXMLResourceName()));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
