/* ButtonsFiveCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * Partnerklasse van {@code ButtonsFive.fxml}
 */
public class ButtonsFiveCompanion implements EventHandler<ActionEvent> {

    public Pane buttonPanel;

    public Label blzLabel;

    public int blz = 1;

    private IncrementButton[] buttons;

    public void initialize() {
        
        buttons = new IncrementButton[]{
            new IncrementButton(-10, "Min tien"),
            new IncrementButton(-1, "Min één"),
            new IncrementButton(+1, "Plus één"),
            new IncrementButton(+10, "Plus tien")
        };

        for (Button button : buttons) {
            buttonPanel.getChildren().add(button);
            button.setOnAction(this);
            // of:
            //button.setOnAction (this::handle);
        }

        adjustBlzLabel(0);
    }

    public void adjustBlzLabel(int increment) {
        blz += increment;
        blzLabel.setText("Blz " + blz);
        for (IncrementButton button : buttons) {
            button.disableIfNecessary(blz);
        }
    }

    @Override
    public void handle(ActionEvent event) {
        IncrementButton sourceButton = (IncrementButton) event.getSource();
        adjustBlzLabel(sourceButton.getIncrement());
    }
}
