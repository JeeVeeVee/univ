/* ToUpper.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *  Doet al het werk voor {@link ToUpperMain}
 */
public class ToUpper {

    public void translate (String in, String out) {
        try {
            Path inpath = Paths.get(in);
            List<String> result = new ArrayList<>();
            Iterable<String> strings = Files.readAllLines(inpath);
            for (String string : strings) {
                result.add(string.toUpperCase());
            }
            Path outpath = Paths.get(out);
            Files.write(outpath, result);
        } catch (IOException e) {
            System.err.println("Kon vertaling niet doen wegens een invoer- of uitvoerfout: " + e);
        }
    }

}
