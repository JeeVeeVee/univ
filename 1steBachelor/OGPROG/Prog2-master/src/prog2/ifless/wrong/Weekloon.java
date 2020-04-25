/* Weekloon.java
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
public class Weekloon {

    private double basisloon;

    /**
     * Berekent het dagloon afhankelijk van het basisloon en de dag van de week.
     */
    public double dagloon(int dag) {
        if (dag == 0) {
            return basisloon * 2.3;  // zondag
        } else if (dag == 6) {
            return basisloon * 1.7;  // zaterdag
        } else if (dag == 1) {
            return basisloon * 1.1;  // maandag
        } else {
            return basisloon;
        }
    }
}
