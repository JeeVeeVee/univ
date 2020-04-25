/* TafelsVanZeven.java
 * ============================================================
 * Copyright (C) 2001-2012 Universiteit Gent
 * 
 * Bijlage bij de cursus 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Schrijft de tafels van 7 uit naar het bestand tafels-van-zeven.txt
 */
public class TafelsVanZeven {
    
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("tafels-van-zeven.txt");
        try (PrintWriter out = new PrintWriter (
                    Files.newBufferedWriter(path, Charset.defaultCharset()) ) 
            ){
            for (int i = 1; i < 10; i++) {
                out.println("7 x " + i + " = " + (7*i));
            }
        }
    }
    
}
