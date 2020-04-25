/* MessageFormatExampleTwoMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.i18n;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Toont ook een informatievenster met een geïnternationaliseerd bericht.
 */
public class MessageFormatExampleTwoMain extends Application {       
    
    @Override
    public void start(Stage stage) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("prog2/i18n/i18n");
        FXMLLoader loader = new FXMLLoader (
                MessageFormatExampleTwoMain.class.getResource("MessageFormatExampleTwo.fxml"),
                bundle
                );
        
        Scene scene = new Scene(loader.load());
        MessageFormatExampleTwoCompanion mfeCompanion = loader.getController();
        mfeCompanion.setStage(stage);
        
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
