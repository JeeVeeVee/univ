/* ButtonsThreeCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.buttons;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Partnerklasse van {@code ButtonsThree.fxml}
 */
public class ButtonsThreeCompanion {

    public Button minus1;

    public Button minus10;

    public Button plus1;

    public Button plus10;

    public Label blzLabel;

    public int blz = 1;

    public void initialize() {
        adjustBlzLabel(0);
    }

    public void adjustBlzLabel(int increment) {       
        blz += increment;
        blzLabel.setText("Blz " + blz);
        minus1.setDisable(blz - 1 < 1);
        minus10.setDisable(blz - 10 < 1);
        plus1.setDisable(blz + 1 > 100);
        plus10.setDisable(blz + 10 > 100);
    }

    public void doButton(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        adjustBlzLabel(Integer.parseInt(sourceButton.getText()));
    }
}
