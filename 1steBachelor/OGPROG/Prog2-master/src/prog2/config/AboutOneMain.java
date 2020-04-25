/* AboutOneMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.config;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Toont een informatievenster dat zijn gegevens haalt vanuit het configuratiebestand
 * {@code myapp.properties}.
 */
public class AboutOneMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                AboutOneMain.class.getResource("AboutOne.fxml")
        );

        Scene scene = new Scene(loader.load());
        AboutOneCompanion aboutCompanion = loader.getController();
        aboutCompanion.setStage(stage);

        stage.setScene(scene);
        stage.setTitle("Over MyApp");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
