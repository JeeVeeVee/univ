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
 * Min of meer hetzelfde als {@link prog2.ifless.correct.TekenenBis}.
 * Heeft geen interface {@link Vormtekenaar} nodig maar is minder leesbaar.
 */
public class TekenenTer {

    private Map<Character, Runnable> map;

    public TekenenTer() {
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
        map.get(toets).run();
    }

    private void tekenCirkel() {
        System.out.println("Dit tekent een cirkel");
    }

    private void tekenDriehoek() {
        System.out.println("Dit tekent een driehoek");
    }

    private void tekenVierkant() {
        System.out.println("Dit tekent een vierkant");
    }


}
