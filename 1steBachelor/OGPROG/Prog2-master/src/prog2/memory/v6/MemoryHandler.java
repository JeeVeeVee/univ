/* MemoryHandler.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.memory.v6;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * Houdt bij welke knoppen er al zijn ingedrukt.
 */
public class MemoryHandler {

    private Button first = null;

    private Button second = null;

    public void buttonClicked(Button button) {
        if (first == null) {
            first = button;
        } else if (second == null && button != first) {
            if (sameImage(first, button)) {
                first = null;
            } else {
                second = button;
            }
        }
    }

    public boolean clickEnabled() {
        return second == null;
    }

    public void resetButtons() {
        first.setGraphic(new ImageView(FruitPane.UNKNOWN_IMAGE));
        second.setGraphic(new ImageView(FruitPane.UNKNOWN_IMAGE));

        first = null;
        second = null;
    }

    private boolean sameImage(Button b1, Button b2) {
        return ((ImageView) b1.getGraphic()).getImage() == ((ImageView) b2.getGraphic()).getImage();
    }

}
