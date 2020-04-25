/* PageLabel.java
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
import javafx.scene.control.Label;

/**
 * Label dat een bladzijdenummer kan afbeelden. Dient als view voor een
 * {@link PageModel}.
 */
public class PageLabel extends Label implements InvalidationListener {
    
    private PageModel model;
    
    /**
     * Stel het model in. Moet worden opgeroepen binnen de initialize-methode van
     * de partnerklasse van het FXML-bestand.
     */
    public void setModel (PageModel model) {
        this.model = model;
        model.addListener (this);
    }

    // getter is nodig om het attribuut 'model' te kunnen gebruiken in ButtonsSeven.fxml
    public PageModel getModel() {
        return model;
    }
    
    
    
    // Implementatie van InvalidationListener.
    @Override
    public void invalidated (Observable o) {
        setText ("Blz. " + model.getNumber ());
    }
    
}
