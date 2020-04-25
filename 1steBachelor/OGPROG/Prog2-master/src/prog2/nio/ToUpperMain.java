/* ToUpperMain.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.nio;

/**
 * Leest een bestand in, zet de inhoud om naar hoofdletters en schrijft het bestand opnieuw uit.
 * Bestandsnamen moeten worden opgegeven op de opdrachtlijn.
 */
public class ToUpperMain {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java prog2.nio.ToUpperMain infile outfile");
        } else {
            new ToUpper().translate (args[0], args[1]);
        }
    }
}
