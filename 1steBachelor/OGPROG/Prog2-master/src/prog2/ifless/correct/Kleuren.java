/* Kleuren.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.correct;

import javafx.scene.paint.Color;

import java.util.Map;

/**
 *
 */
public class Kleuren {

    private Map<String, Color> colorMap = Map.of(
            "geel", Color.YELLOW,
            "oranje", Color.ORANGE,
            "rood", Color.RED
    );

    /**
     * Kies een kleur aan de hand van zijn naam.
     */
    public Color stringToColor(String naam) {
        Color result = colorMap.get(naam);
        if (result == null) {
            throw new IllegalArgumentException("Kleur onbekend");
        } else {
            return result;
        }
    }
}
