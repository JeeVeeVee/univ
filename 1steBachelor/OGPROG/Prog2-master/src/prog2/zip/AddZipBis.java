/* AddZipBis.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.zip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Ingekorte versie van {@link AddZip}. Maakt ook op een betere manier gebruik van het prepared statement.
 */
public class AddZipBis {

    private static final String JDBC_URL = "jdbc:sqlite:zipcodes.sqlite";

    public static void main(String[] args) {
        // verbind met de databank en voeg de gemeente toe
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO town(zip,name) VALUES (?,?)"
             )) {
            stmt.setString(1, args[0]);
            stmt.setString(2, args[1]);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Database error: " + e);
        }
    }
}
