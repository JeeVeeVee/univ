/* Richtingen.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.wrong;

/**
 * Versie van {@link Richtingen} zonder opsomtype.
 */
public class RichtingenBis {

    private int x;

    private int y;

    private static final int OOST = 0;
    private static final int ZUID = 1;
    private static final int WEST = 2;
    private static final int NOORD = 3;


    /**
     * Beweeg in de aangegeven richting
     */
    public void beweeg(int richting) {
        if (richting == OOST) {
            x++;
        } else if (richting == ZUID) {
            y--;
        } else if (richting == WEST) {
            x--;
        } else {  // richting moet nu NOORD zijn
            y++;
        }
    }

    /**
     * Andere notatie, met switch. Leest iets gemakkelijker maar
     * ontwerp is niet beter dan de vorige versie
     */
    public void beweeg2(int richting) {
        switch (richting) {
            case OOST:
                x++;
                break;
            case ZUID:
                y--;
                break;
            case WEST:
                x--;
                break;
            case NOORD:
                y++;
                break;
        }
    }

}
