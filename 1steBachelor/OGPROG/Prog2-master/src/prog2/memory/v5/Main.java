/* MailBox.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.memory.v5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Memory-oefening. Versie 5.
 *
 * Introductie van {@link MemoryHandler}. Je kan twee knoppen aanklikken
 * als de afbeeldingen verschillend zijn, dan kan je niet meer op een derde
 * knop klikken.
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
