/* IncrementButton.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.buttons;

import javafx.scene.control.Button;

/**
 * Knop met een geassocieerd increment.
 */
public class IncrementButton extends Button  {
    
    private int increment;

    public IncrementButton () {
    // Er moet een publieke constructor zijn zonder argumenten opdat deze klasse in FXML zo kunnen
    // gebruikt worden. Om dezelfde reden is er ook een setter voor 'increment'
    }
    
    public IncrementButton (int increment, String caption) {
        super (caption);
        setIncrement(increment);
    }
    
    public int getIncrement () {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }
    
    public void disableIfNecessary (int blz) {
        setDisable(blz + increment < 1 || blz + increment > 100);
    }
    
}
