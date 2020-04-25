/* MessageFormatExampleTwoCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.i18n;

import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Partnerklasse voor {@code MessageFormatExampleTwo.fxml}
 */
public class MessageFormatExampleTwoCompanion {

    public Label messageLabel;

    public ResourceBundle resources;

    private Stage stage;

    public void initialize() {
        String pattern = resources.getString("message.two");
        // MessageFormat ondersteunt blijkbaar nog geen LocalDate...
        String message = MessageFormat.format(pattern,
                new Date(), new Date(), 1253764
        );
        messageLabel.setText(message);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void doClose() {
        stage.close();
    }
}
