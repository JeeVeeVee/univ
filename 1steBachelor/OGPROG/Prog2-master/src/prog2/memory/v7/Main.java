/* MailBox.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.memory.v7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Memory-oefening. Versie 7.
 *
 * Knoppen keren na 2.5 seconden zelf terug naar hun
 * 'omgedraaide' toestand. (Werkte echter nog steeds  niet perfect...)
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
