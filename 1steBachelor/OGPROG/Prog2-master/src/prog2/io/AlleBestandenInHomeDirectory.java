/* AlleBestandenInHomeDirectory.java
 * ============================================================
 * Copyright (C) 2001-2012 Universiteit Gent
 * 
 * Bijlage bij de cursus 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Drukt de namen af van alle bestanden (en directories) in de home directory van de
 * gebruiker.
 */
public class AlleBestandenInHomeDirectory {
    
    public static void main(String[] args) throws IOException {
        Path homeDirectory = Paths.get(System.getProperty("user.home") );
        System.out.println("Bestanden in directory " + homeDirectory);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(homeDirectory)) {
            for (Path p : ds) {
                System.out.println(p);
            }
        }
    }
    
}
