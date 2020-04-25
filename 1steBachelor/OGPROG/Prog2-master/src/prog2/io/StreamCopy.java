/* StreamCopy.java
 * ============================================================
 * Copyright (C) 2001-2012 Universiteit Gent
 * 
 * Bijlage bij de cursus 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Copieert de inhoud van een reader naar een writer.
 */
public class StreamCopy {

    // merk op dat je vanaf Java 7 met Files.copy (...) bestanden kunt copiëren op een veel eenvoudiger
    // manier dan deze...  Dit werkt echter alleen met bestanden en
    // niet met andere streams

    //
    private static void streamCopy(Reader invoer, Writer uitvoer)
            throws IOException {
        char[] buffer = new char[256];
        int len = invoer.read(buffer);
        while (len >= 0) {
            uitvoer.write(buffer, 0, len);
            len = invoer.read(buffer);
        }
    }

    //
    public static void main(String[] args) throws IOException {
        try (Reader rd = new InputStreamReader(System.in);
             Writer wr = new PrintWriter(System.out)) {
            streamCopy(rd, wr);
        }
        // zowel invoer als uitvoer worden automatisch gesloten door de try-met-bronnen
    }
}
