/* MailBox.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.memory.v1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Memory-oefening. Versie 1.
 *
 * Bouwt de scene op. Alle knoppen tonen dezelfde afbeelding. Drukken op een
 * knop drukt enkel een bericht af.
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Image unknownImage = new Image ("/prog2/memory/images/unknown.png");
        
        GridPane root = new GridPane();
        for (int row=0; row < 4; row++) {
            for (int column=0; column < 4; column++) {
                Button button = new Button(null, new ImageView(unknownImage));
                button.setOnAction( e ->  System.out.println("Clicked") );
                root.add(button, column, row);
            }
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch (args);
    }
    
}
