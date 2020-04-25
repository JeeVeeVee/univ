/* TekenenBis.java
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
 * Zelfde als {@link Tekenen} maar gebruikt Java 8.
 */
public class TekenenBis {

    private Map<Character, Vormtekenaar> map;

    public TekenenBis() {
        map = Map.of(
                'C', () -> tekenCirkel(),
                'D', () -> tekenDriehoek(),
                'V', () -> tekenVierkant()
        );
        // of
        map = Map.of(
                'C', this::tekenCirkel,
                'D', this::tekenDriehoek,
                'V', this::tekenVierkant
        );
    }

    /**
     * Teken de correcte figuur afhankelijk van welke toets er is ingedrukt
     */
    public void tekenFiguur(char toets) {
        map.get(toets).tekenVorm();
    }

    private void tekenCirkel() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void tekenDriehoek() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void tekenVierkant() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
