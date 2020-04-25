/* PageButton.java
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Knop waarmee een {@link PageModel} kan worden aangepast. Laat niet toe dat
 * het model waarden krijgt buiten het gebied 0..100.
 */
public class PageButton extends Button implements InvalidationListener, EventHandler<ActionEvent> {

    public PageButton() {
        setOnAction(this);
    }
    
    private PageModel model;

    // getter is nodig om het attribuut 'model' te kunnen gebruiken in ButtonsSeven.fxml
    public PageModel getModel() {
        return model;
    }

    public void setModel(PageModel model) {
        this.model = model;
        model.addListener(this);
    }

    /**
     * Het increment voor deze knop.
     */
    private int increment;

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    @Override
    public void invalidated(Observable o) {
        int blz = model.getNumber();
        setDisable(blz + increment < 1 || blz + increment > 100);
    }

    @Override
    public void handle(ActionEvent t) {
        model.incrementNumber(increment);
    }
}
