/* Tekenen.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.correct;

import java.util.Map;

/**
 *
 */
public class Tekenen {

    private Map<Character, Vormtekenaar> map;

    public Tekenen() {
        map = Map.of(
                'C', new Cirkeltekenaar(),
                'D', new Driehoektekenaar(),
                'V', new Vierkanttekenaar()
        );
    }

    /**
     * Teken de correcte figuur afhankelijk van welke toets er is ingedrukt
     */
    public void tekenFiguur(char toets) {
        map.get(toets).tekenVorm();
    }
}
