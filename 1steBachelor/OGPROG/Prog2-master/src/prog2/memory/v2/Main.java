/* MailBox.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.memory.v2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Memory-oefening. Versie 2.
 *
 * Paneel afgezonderd van het hoofdprogramma. Drukken op een knop verandert de
 * afbeelding in een aardbei.
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
