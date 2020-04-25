/* ButtonsNineCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.buttons;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Partnerklasse van {@code ButtonsNine.fxml}
 */
public class ButtonsNineCompanion implements InvalidationListener {

    public PageModel model;

    public Button minus1;

    public Button minus10;

    public Button plus1;

    public Button plus10;

    public Label blzLabel;

    public ButtonsNineCompanion(PageModel model) {
        this.model = model;
        model.addListener(this);
    }

    public void initialize() {
        model.setNumber(1);
    }

    public void doMinus1() {
        model.incrementNumber(-1);
    }

    public void doMinus10() {
        model.incrementNumber(-10);
    }

    public void doPlus1() {
        model.incrementNumber(1);
    }

    public void doPlus10() {
        model.incrementNumber(10);
    }

    @Override
    public void invalidated(Observable observable) {
        int blz = model.getNumber();

        blzLabel.setText("Blz " + blz);
        minus1.setDisable(blz - 1 < 1);
        minus10.setDisable(blz - 10 < 1);
        plus1.setDisable(blz + 1 > 100);
        plus10.setDisable(blz + 10 > 100);
    }
}
