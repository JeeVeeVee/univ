/* ButtonsElevenCompanion.java
 * ============================================================
 * Copyright (C) 2012-2019 Universiteit Gent
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
 * Partnerklasse van {@code ButtonsEleven.fxml}
 */
public class ButtonsElevenCompanion {

    public Button minus1;

    public Button minus10;

    public Button plus1;

    public Button plus10;

    public Label blzLabel;

    public int blz = 1;

    public void initialize() {
        adjustBlzLabel(0);

        // Je kan de user data ook in de initialize initialiseren, zoals
        // hieronder getoond. Maar het is beter om 'userData'-attributen te
        // in de FXML
/*
        minus1.setUserData("-1");
        minus10.setUserData("-10");
        plus1.setUserData("1");
        plus10.setUserData("10");
*/
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
        String userData = (String)sourceButton.getUserData();
        adjustBlzLabel(Integer.parseInt(userData));
    }
}
