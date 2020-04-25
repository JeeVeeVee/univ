/* ButtonsEightCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.buttons;

/**
 * Partnerklasse van {@code ButtonsEight.fxml}
 */
public class ButtonsEightCompanion {

    public PageModel model;

    public void initialize() {
        model.setNumber(1); // zorgt meteen voor het disablen/enablen van de juiste knoppen
    }
}
