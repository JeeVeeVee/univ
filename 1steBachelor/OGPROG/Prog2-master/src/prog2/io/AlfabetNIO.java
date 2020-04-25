/* Alfabet.java
 * ============================================================
 * Copyright (C) 2001-2012 Universiteit Gent
 * 
 * Bijlage bij de cursus 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Schrijft alle lettertekens uit van A tot Z. Gebruikt klasse Files om een buffered writer
 * te openen voor een bestand.
 */
public class AlfabetNIO {

    //
    public static void main(String[] args) throws IOException {
        try (BufferedWriter uitvoer = Files.newBufferedWriter(
                Paths.get("alfabet.out"), Charset.defaultCharset()) // of StandardCharsets.UTF_8)
                ) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                uitvoer.write(ch);
            }
        }
    }
}
