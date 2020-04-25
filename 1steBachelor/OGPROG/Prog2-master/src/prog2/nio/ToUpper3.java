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
 *  Zelfde als een combinatie van {@link ToUpper2} en {@link ToUpper2Main} maar
 *  gebruikt try-met-bronnen.
 */
public class ToUpper3 {

    private Iterable<String> readAllLines(Path inPath) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(inPath)) {
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Fout bij het inlezen:" + e);
        }
        return result;
    }

    private void write(Path outPath, Iterable<String> result) {
        try (BufferedWriter writer = Files.newBufferedWriter(outPath);
             PrintWriter out = new PrintWriter(writer, true)) {
            for (String s : result) {
                out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void translate (String in, String out) {
        List<String> result = new ArrayList<>();
        for (String string : readAllLines(Paths.get(in))) {
            result.add(string.toUpperCase());
        }
        write(Paths.get(out), result);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java prog2.nio.ToUpperMain infile outfile");
        } else {
            new ToUpper3().translate (args[0], args[1]);
        }
    }

}
