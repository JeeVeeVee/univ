/* ToUpper2Main.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.nio;

/**
 * Zelfde functionaliteit als {@link ToUpperMain}
 */
public class ToUpper2Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java prog2.nio.ToUpper2Main infile outfile");
        } else {
            new ToUpper2().translate (args[0], args[1]);
        }
    }
}
