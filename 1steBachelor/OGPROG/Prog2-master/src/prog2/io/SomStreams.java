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
 * Variant op Som die een Java 8 stream gebruikt. (Stopt echter niet bij
 * een lege lijn, maar enkel bij EOF.)
 */
public class SomStreams {

    public static void main(String[] args) {
        try (BufferedReader invoer =
                        new BufferedReader(new InputStreamReader(System.in))) {
            double som = invoer.lines()
                    .mapToDouble(Double::parseDouble)
                    .sum();

            System.out.println("De som van deze getallen is " + som);
        } catch (IOException | NumberFormatException e) {
            // IOException en NumberFormatException
            System.err.println(e);
        }
    }
}
