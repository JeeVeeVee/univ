/* Som.java
 * ============================================================
 * Copyright (C) 2001-2012 Universiteit Gent
 * 
 * Bijlage bij de cursus 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Leest een reeks getallen in en bepaalt de som. Elke lijn bevat 1 getal en de
 * lijst wordt afgesloten met een lege lijn of EOF.
 */
public class Som {

    public static void main(String[] args) {
        try (BufferedReader invoer =
                        new BufferedReader(new InputStreamReader(System.in))) {
            double som = 0.0;

            String lijn = invoer.readLine();
            while (lijn != null && lijn.length() != 0) {
                som += Double.parseDouble(lijn);
                lijn = invoer.readLine();
            }

            System.out.println("De som van deze getallen is " + som);
        } catch (IOException | NumberFormatException e) {
            // IOException en NumberFormatException
            System.err.println(e);
        }
    }
}
