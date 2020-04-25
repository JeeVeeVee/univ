/* Richtingen.java
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
public class RichtingenBis {

    private int x;

    private int y;

    private static final int OOST = 0;
    private static final int ZUID = 1;
    private static final int WEST = 2;
    private static final int NOORD = 3;

    private static int[] DX = {1, 0, -1, 0};

    private static int[] DY = {0, -1, 0, 1};

    /**
     * Beweeg in de aangegeven richting.
     */
    public void beweeg(int richting) {
        x += DX[richting];
        y += DY[richting];
    }

}
