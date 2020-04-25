/* PageModel.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.buttons;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * Model dat een bladzijdenummer bijhoudt.
 */
public class PageModel implements Observable {

    /**
     * Bladzijdenummer
     */
    private int number;
    
    /**
     * Haal dhet bladzijdenummer op.
     */
    public int getNumber () {
        return number;
    }
    
    /**
     * Stel het bladzijdenummer in en breng indien nodig alle geregistreerde luisteraars 
     * hiervan op de hoogte.
     */
    public void setNumber (int number) {
        if (number != this.number) {
            this.number = number;
            fireInvalidationEvent();
        }
    }
    
    /**
     * Verhoog de waarde met het gegeven aantal.
     */
    public void incrementNumber (int increment) {
        if (increment != 0) {
            this.number += increment;
            fireInvalidationEvent();
        }
    }
    
    /**
     * Lijst van geregistreerde luisteraars.
     */
    private List<InvalidationListener> listenerList = new ArrayList<> ();
    
     
    /**
     * Breng alle luisteraars op de hoogte van een verandering van het model.
     */
    private void fireInvalidationEvent () {
        for (InvalidationListener listener : listenerList) {
            listener.invalidated(this);
        }
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.remove(listener);
    }
    
}
