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
public class Richtingen {

    private int x;

    private int y;

    private static int[] DX = {1, 0, -1, 0};

    private static int[] DY = {0, -1, 0, 1};

    /**
     * Beweeg in de aangegeven richting. (Nog niet ideaal.)
     */
    public void beweeg(Windrichting richting) {
        x += DX[richting.ordinal()];
        y += DY[richting.ordinal()];
    }

    /**
     * Beweeg in de aangegeven richting, (Via opsomtype.)
     */
    public void beweeg2(Windrichting richting) {
        x += richting.getDx();
        y += richting.getDy();
    }
}
