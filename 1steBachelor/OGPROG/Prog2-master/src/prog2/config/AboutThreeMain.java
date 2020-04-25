/* AboutThreeMain.java
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
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Derde versie van hetzelfde programma. Illustreert hoe men componenten
 * (en delen van componenten) kan inladen met behulp van FXMLoader en tegelijk
 * gebruik maken van overerving om toe te laten code te herbruiken.
 */
public class AboutThreeMain extends Application {       
    
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new AboutThreeComponent(stage));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
