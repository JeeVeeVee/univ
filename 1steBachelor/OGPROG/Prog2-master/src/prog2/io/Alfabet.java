/* Alfabet.java
 * ============================================================
 * Copyright (C) 2001-2012 Universiteit Gent
 * 
 * Bijlage bij de cursus 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Schrijft alle lettertekens uit van A tot Z.
 */
public class Alfabet {

    //
    public static void main(String[] args) throws IOException {
        try (Writer uitvoer = new FileWriter("alfabet.out")) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                uitvoer.write(ch);
            }
        }
    }
}
