/* AddZip.java
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
 * Dit zeer eenvoudige programma voegt het record '9999 - Rivendel' toe aan de databank
 */
public class AddZip {

    private static void add(Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO town(zip,name) VALUES ('9999' ,'Rivendel')")) {
            stmt.executeUpdate();
        }
    }

    private static final String JDBC_URL = "jdbc:sqlite:zipcodes.sqlite";

    public static void main(String[] args) {
        // verbind met de databank en voeg de gemeente toe
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            add(conn);
        } catch (SQLException e) {
            System.err.println("Database error: " + e);
        }
    }

}
