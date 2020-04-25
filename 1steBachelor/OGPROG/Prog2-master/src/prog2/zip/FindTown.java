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
 * Eenvoudige toepassing waarmee je de gemeente met een bepaald postnummer kunt
 * opzoeken in een databank.
 */
public class FindTown {

    /**
     * Zoek alle gemeenten op met het opgegeven postnummer.
     */
    private static void findTowns(Connection conn, String zip)
            throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "SELECT name FROM town WHERE zip=?")) {
            stmt.setString(1, zip);
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    System.out.println(res.getString("name"));
                }
            }
        }
    }

    private static final String JDBC_URL = "jdbc:sqlite::resource:prog2/zip/zipcodes.sqlite";

    /**
     * Drukt alle gemeenten af waarvan de postnummers zich op de opdrachtlijn
     * bevinden.
     */
    public static void main(String[] args) {

        // verbind met de databank en zoek de gemeentes op
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            System.out.println("Gemeenten met de opgegeven postnummers:");
            for (String arg : args) {
                findTowns(conn, arg);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e);
        }
    }
}
