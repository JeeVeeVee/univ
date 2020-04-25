/* MemoryHandler.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.memory.v5;

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
    
    public boolean clickEnabled () {
        return second == null;
    }
    
    private boolean sameImage (Button b1, Button b2) {
        ImageView iv1 = (ImageView)b1.getGraphic();
        ImageView iv2 = (ImageView)b2.getGraphic();
        return iv1.getImage() == iv2.getImage();
    }
    
}
