/* ButtonsOneCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.buttons;

import javafx.scene.control.Label;

/**
 * Partnerklasse van {@code ButtonsOne.fxml}
 */
public class ButtonsOneCompanion  {
 
    public Label blzLabel;
    
    public int blz = 1;
    
    public void doMinus1 () {
        blz --;
        blzLabel.setText ("Blz " + blz);
    }    
    
    public void doMinus10 () {
        blz -= 10;
        blzLabel.setText ("Blz " + blz);
    }
    
    public void doPlus1 () {
        blz ++;
        blzLabel.setText ("Blz " + blz);
    }
    
    public void doPlus10 () {
        blz += 10;
        blzLabel.setText ("Blz " + blz);
    }
    
}
