/* MemoryHandler.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.memory.v8;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Houdt bij welke knoppen er al zijn ingedrukt.
 */
public class MemoryHandler {

    private FruitButton first = null;

    private FruitButton second = null;

    public void buttonClicked(FruitButton button) {
        if (first == null) {
            first = button;
        } else if (second == null && button != first) {
            if (sameImage(first, button)) {
                first = null;
            } else {
                second = button;
                initiateReset();
            }
        }
    }

    public boolean clickEnabled() {
        return second == null;
    }

    private void resetButtons() {
        first.reset();
        second.reset();

        first = null;
        second = null;
    }

    private boolean sameImage(FruitButton b1, FruitButton b2) {
        return b1.getImage() == b2.getImage();
    }

    private void initiateReset() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2.5), t -> resetButtons())
        );
        timeline.setCycleCount(1);
        timeline.play();
    }
   

}
