/* Adventure.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.wrong;

/**
 *
 */
public class Adventure {

    public void print(Player[] tabel) {
        for (Player p : tabel) {
            if (p instanceof Wizard) {
                System.out.println("Tovenaar");
            } else if (p instanceof Dwarf) {
                System.out.println("Dwerg");
            } // ...
        }
    }
}
