/* MailBox.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.memory.v8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Memory-oefening. Versie 8.
 *
 * Gebruikt nu eigen soort knop {@link FruitButton} in plaats van een interne
 * klasse {@code ButtonHandler}. Dit is een 'refactoring' van versie 7 met de bedoeling
 * om later de 'bug' eruit te halen.
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
