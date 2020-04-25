/* ToUpper3.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Doet al het werk voor {@link ToUpper2Main}
 */
public class ToUpper2 {

    private Iterable<String> readAllLines(Path inPath) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(inPath);
            try {
                String line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            System.err.println("Fout bij het inlezen:" + e);
        }
        return result;
    }

    private void write(Path outPath, Iterable<String> result) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(outPath);
            PrintWriter out = new PrintWriter(writer, true);
            for (String s : result) {
                out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void translate(String in, String out) {
        List<String> result = new ArrayList<>();
        for (String string : readAllLines(Paths.get(in))) {
            result.add(string.toUpperCase());
        }
        write(Paths.get(out), result);
    }

}
