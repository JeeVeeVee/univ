/* Weekloon.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.correct;

/**
 *
 */
public class Weekloon {

    private double basisloon;

    private static final double[] LOONFACTOR = {
        2.3, 1.1, 1.0, 1.0, 1.0, 1.0, 1.7
    };

    /**
     * Berekent het dagloon afhankelijk van het basisloon en de dag van de week.
     */
    public double dagloon(int dag) {
        return basisloon * LOONFACTOR[dag];
    }
}
