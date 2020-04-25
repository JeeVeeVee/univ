/* ButtonsTenCompanion.java
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
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Alternatieve partnerklasse voor {@code ButtonsNine.fxml}
 */
public class ButtonsTenCompanion implements InvalidationListener {

    public IntegerProperty pageNumber;

    public Button minus1;

    public Button minus10;

    public Button plus1;

    public Button plus10;

    public Label blzLabel;

    public ButtonsTenCompanion(IntegerProperty pageNumber) {
        this.pageNumber = pageNumber;
        pageNumber.addListener(this);
    }

    public void initialize() {
        pageNumber.set(1);
    }

    public void doMinus1() {
        pageNumber.set(pageNumber.get()-1);
    }

    public void doMinus10() {
        pageNumber.set(pageNumber.get()-10);
    }

    public void doPlus1() {
        pageNumber.set(pageNumber.get()+1);
    }

    public void doPlus10() {
        pageNumber.set(pageNumber.get()+10);
    }

    @Override
    public void invalidated(Observable observable) {
        int blz = pageNumber.get();

        blzLabel.setText("Blz " + blz);
        minus1.setDisable(blz - 1 < 1);
        minus10.setDisable(blz - 10 < 1);
        plus1.setDisable(blz + 1 > 100);
        plus10.setDisable(blz + 10 > 100);
    }
}
