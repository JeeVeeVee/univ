/* QuickPickSevenMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.quickpick;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Eenvoudig programma waarmee de gebruiker via een grafische gebruikersinterface reeksen willekeurige
 * lottocijfers kan genereren.
 * <p>De implementatie is een illustratie van hoe men een GUI kan bouwen <i>zonder</i> gebruik te maken
 * van FXML (hoewel dit bij dit voorbeeld niet echt de gemakkelijkste manier van werken is).</p>
 */
public class QuickPick extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new QuickPickPane());
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
