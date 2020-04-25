/* AboutTwoMain.java
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
 * Alternatief voor {@link AboutOneMain} dat gebruik maakt van JDOM.
 */
public class AboutTwoMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                AboutTwoMain.class.getResource("AboutTwo.fxml")
        );

        Scene scene = new Scene(loader.load());
        AboutTwoCompanion aboutCompanion = loader.getController();
        aboutCompanion.setStage(stage);

        stage.setScene(scene);
        stage.setTitle("Over MyApp");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
