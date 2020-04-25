/* MailBox.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.memory.v3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Memory-oefening. Versie 3.
 *
 * De acht fruitafbeeldingen worden op voorhand ingeladen. Drukken op een
 * knop toont één van die afbeeldingen. Afbeeldingen staan nog op een
 * vaste plaats.
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Scene scene = new Scene(new FruitPane());
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch (args);
    }
    
}
