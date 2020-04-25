/* Internationaal.java
 * ============================================================
 * Copyright (C) 2001-2012 Universiteit Gent
 * 
 * Bijlage bij de cursus 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * Drukt een tabel af met internationale lettertekens, volgens een bepaalde
 * codering. Kan bijvoorbeeld worden opgeroepen met
 * <pre>
 *     java prog2.io.Internationaal ISO-8859-1
 *     java prog2.io.Internationaal UTF-8
 * </pre>
 */
public class Internationaal {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("usage: java prog2.io.Internationaal <codering>");
            System.exit(0);
        }
        String nl = System.getProperty("line.separator");
        try (Writer uit = new OutputStreamWriter(System.out, Charset.forName(args[0]))) {
            for (int c = 0; c < 2; c++) {
                for (int i = 2; i < 8; i++) {
                    for (int j = 0; j < 16; j++) {
                        uit.write(128 * c + 16 * i + j);
                        uit.write(' ');
                    }
                    uit.write(nl);
                }
            }
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Onbekende encodering: " + ex.getMessage());
            System.exit(0);
        } catch (IOException ex) {
            System.err.println("Uitvoerfout: " + ex);
        }
    }
}
