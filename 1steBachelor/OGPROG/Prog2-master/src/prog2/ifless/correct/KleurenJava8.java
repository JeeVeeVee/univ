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

import java.util.HashMap;
import java.util.Map;

/**
 * Oudere versie van {@link prog2.ifless.correct.Kleuren}, toen de methoden
 * {@code Map.of(...)} nog niet bestonden.
 */
public class KleurenJava8 {

    private Map<String, Color> colorMap = new HashMap<>();

    public KleurenJava8() {
        colorMap.put("geel", Color.YELLOW);
        colorMap.put("oranje", Color.ORANGE);
        colorMap.put("rood", Color.RED);
    }

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
