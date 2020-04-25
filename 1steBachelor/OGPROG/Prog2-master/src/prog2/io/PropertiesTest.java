/* PropertiesTest.java
 * ============================================================
 * Copyright (C) 2001-2012 Universiteit Gent
 * 
 * Bijlage bij de cursus 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  Toont hoe eigenschapsbestanden kunnen worden gelezen (vanuit het class path)
 */
public class PropertiesTest {

    /**
     *  Leest het bestand <tt>connection.properties</tt> en drukt de waarde van
     * de eigenschap <tt>server</tt>.
     */
    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream in = PropertiesTest.class.getResourceAsStream("connection.properties")) {
            props.load(in);
            System.out.println("Server: " + props.getProperty("server"));
        } catch (IOException ex) {
            System.out.println("Kon eigenschappen niet lezen: " + ex);
        }
    }
}
