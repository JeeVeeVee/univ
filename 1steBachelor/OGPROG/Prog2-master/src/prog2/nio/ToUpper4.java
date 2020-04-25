/* ToUpper4.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.nio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *  Zelfde als {@link ToUpper3} maar leest van standaard invoer en schrijft naar standaard uitvoer.
 *  (Moeilijker te testen in IntelliJ maar veel bruikbaarder.)
 */
public class ToUpper4 {

    private Iterable<String> readAllLines(InputStream in) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(in, StandardCharsets.UTF_8))
        ) {
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

    private void write(OutputStream stream, Iterable<String> result) {
        try (Writer writer =
                new OutputStreamWriter(stream, StandardCharsets.UTF_8)) {
            PrintWriter out = new PrintWriter(writer);
            for (String s : result) {
                out.println(s);
            }
        } catch (IOException e) {
            System.err.println("Fout bij het uitschrijven:" + e);
        }
    }

    public void translate () {
        List<String> result = new ArrayList<>();
        for (String string : readAllLines(System.in)) {
            result.add(string.toUpperCase());
        }
        write(System.out, result);
    }

    public static void main(String[] args) {
        new ToUpper4().translate ();
    }

}
