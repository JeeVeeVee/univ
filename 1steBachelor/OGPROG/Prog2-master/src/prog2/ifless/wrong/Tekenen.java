/* Tekenen.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.wrong;

/**
 *
 */
public class Tekenen {

    /**
     * Teken de correcte figuur afhankelijk van welke toets er is ingedrukt
     */
    public void tekenFiguur(char toets) {
        if (toets == 'C') {
            tekenCirkel();
        } else if (toets == 'D') {
            tekenDriehoek();
        } else if (toets == 'V') {
            tekenVierkant();
        } // ...
    }

    private void tekenCirkel() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void tekenDriehoek() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void tekenVierkant() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
