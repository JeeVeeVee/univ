/* ButtonsSixCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.buttons;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

/**
 * Partnerklasse van {@code ButtonsSix.fxml}
 */
public class ButtonsSixCompanion  {

    public Label blzLabel;

    public int blz = 1;

    public IncrementButton minus1;

    public IncrementButton minus10;

    public IncrementButton plus1;

    public IncrementButton plus10;
    
    private IncrementButton[] buttons;

    public void initialize() {
        
        buttons = new IncrementButton[]{
            minus1, minus10, plus1, plus10
        };
        adjustBlzLabel(0);
    }

    public void adjustBlzLabel(int increment) {
        blz += increment;
        blzLabel.setText("Blz " + blz);
        for (IncrementButton button : buttons) {
            button.disableIfNecessary(blz);
        }
    }

    public void doButton (ActionEvent event) {
        IncrementButton sourceButton = (IncrementButton) event.getSource();
        adjustBlzLabel(sourceButton.getIncrement());
    }
}
