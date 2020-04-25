/* Kleuren.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.wrong;

import javafx.scene.paint.Color;

/**
 *
 */
public class Kleuren {

    /**
     * Kies een kleur aan de hand van zijn naam.
     */
    public Color stringToColor(String naam) {
        if (naam.equals("geel")) {
            return Color.YELLOW;
        } else if (naam.equals("oranje")) {
            return Color.ORANGE;
        } else if (naam.equals("rood")) {
            return Color.RED;
            //} else if{
            //   ...
        } else {
            throw new IllegalArgumentException("Kleur onbekend");
        }
    }
}
