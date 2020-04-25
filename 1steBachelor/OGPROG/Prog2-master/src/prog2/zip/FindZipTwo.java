/* FindZipTwo.java
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
 * <p>
 * Variant op {@link FindZipOne} die herhaaldelijk gebruikt maakt van hetzelfde prepared statement.
 */
public class FindZipTwo {

    /**
     * Zoek alle gemeenten op met de opgegeven naam (of gedeelte ervan).
     */
    private static void findZipCodes(PreparedStatement stmt, String name)
            throws SQLException {
        stmt.setString(1, name);
        try (ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                System.out.println(res.getString("zip") + " " + res.getString("name"));
            }
        }
    }

    private static final String JDBC_URL = "jdbc:sqlite::resource:prog2/zip/zipcodes.sqlite";

    /**
     * Drukt alle gemeenten af waarvan de namen zich op de opdrachtijn
     * bevinden.
     */
    public static void main(String[] args) {
        // verbind met de databank en zoek de gemeentes op
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT zip,name FROM town WHERE name LIKE '%' || ? || '%'"
             )) {
            System.out.println("Gemeenten met de opgegeven postnummers:");
            for (String arg : args) {
                findZipCodes(stmt, arg);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e);
        }
    }
}
