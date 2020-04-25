/* MessageFormatExampleCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.i18n;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Partnerklasse voor {@code MessageFormatExample.fxml}
 */
public class MessageFormatExampleCompanion  {

    public Label messageLabel;
    
    public ResourceBundle resources; // Als het veld deze naam heeft, wordt 
                                     // het automatisch ingevuld door de FXMLLoader
    
    private Stage stage;
    
    public void initialize () {
        messageLabel.setText (
                MessageFormat.format (resources.getString ("message"),
                        "biblecode.txt", "Documents"));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void doClose () {
        stage.close();
    } 
}
