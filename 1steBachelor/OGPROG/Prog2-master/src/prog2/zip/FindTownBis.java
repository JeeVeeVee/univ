/* FindTown.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.zip;

import java.sql.*;

/**
 * Variant op {@link FindTown} waarbij hetzelfde prepared statement meerdere keren wordt gebruikt
 */
public class FindTownBis {


    private static final String JDBC_URL = "jdbc:sqlite::resource:prog2/zip/zipcodes.sqlite";

    /**
     * Drukt alle gemeenten af waarvan de postnummers zich op de opdrachtlijn
     * bevinden.
     */
    public static void main(String[] args) {
        // verbind met de databank en zoek de gemeentes op
        System.out.println("Gemeenten met de opgegeven postnummers:");
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT name FROM town WHERE zip=?"
             )) {
            for (String zip : args) {
                stmt.setString(1, zip);
                try (ResultSet res = stmt.executeQuery()) {
                    while (res.next()) {
                        System.out.printf("%s: %s\n", zip, res.getString("name"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e);
        }
    }
}
