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
import java.util.function.Supplier;

/**
 *  Alternatieve versie van {@link AdventureMain} die gebruikt maakt van lambda's
 */
public class AdventureMainBis {

    public static void main(String[] args) {

        //Map<String, PlayerFactory> factories = new HashMap<>();
        Map<String, Supplier<Player>> factories = Map.of(
                "Tovenaar", Wizard::new, "Dwerg", Dwarf::new
        );

        String naam = args[0];
        //Player p = factories.get(naam).createPlayer();
        Player p = factories.get(naam).get();
    }
}
