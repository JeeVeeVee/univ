/* AdventureMain.java
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
public class AdventureMain {

    public static void main(String[] args) {

        Map<String, PlayerFactory> factories = Map.of(
                "Tovenaar", new WizardFactory(),
                "Dwerg", new DwarfFactory());

        String naam = args[0];
        Player p = factories.get(naam).createPlayer();
    }
}
