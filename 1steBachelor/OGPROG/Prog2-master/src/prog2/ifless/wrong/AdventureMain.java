/* AdventureMain.java
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
public class AdventureMain {

    public static void main(String[] args) {

        String naam = args[0];

        Player p;
        if (naam.equals("Tovenaar")) {
            p = new Wizard();
        } else if (naam.equals("Dwerg")) {
            p = new Dwarf();
        } // ...

    }
}
