/* CloseButtonCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.config;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CloseButtonCompanion {

    private Stage stage;

    public HBox hbox;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void doClose() {
        stage.close();
    }

    public void setContents(Node... components) {
        hbox.getChildren().setAll(components);
    }

    public void addToContents(Node... components) {
        this.hbox.getChildren().addAll(components);
    }


}
