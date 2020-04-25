/* Richtingen.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.wrong;

import static prog2.ifless.wrong.Windrichting.*;

/**
 *
 */
public class Richtingen {

    private int x;

    private int y;

    /**
     * Beweeg in de aangegeven richting
     */
    public void beweeg(Windrichting richting) {
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
    public void beweeg2(Windrichting richting) {
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
