/* DataAccessProvider.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package Oefeningen.students.databank;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Data access provider voor de {@code students} databank.
 */
public class DataAccessProvider  {

    private final Properties databaseProperties;

    public DataAccessProvider() {
        // Ophalen van de databankgegevens
        try (InputStream inp = DataAccessProvider.class.getResourceAsStream("database.properties")) {
            databaseProperties = new Properties();
            databaseProperties.load(inp);
        } catch (IOException ex) {
            throw new RuntimeException("Could not read database properties", ex);
        }
    }

    /**
     * Open een verbinding met de databank.
     */
    private Connection getConnection() throws SQLException {
        String user = databaseProperties.getProperty("user");
        if (user != null) {
            return DriverManager.getConnection(databaseProperties.getProperty("url"),
                    user,
                    databaseProperties.getProperty("password"));
        } else {
            return DriverManager.getConnection(databaseProperties.getProperty("url"));
        }
    }

    public DataAccessContext getDataAccessContext() throws SQLException {
            return new DataAccessContext(getConnection());
    }
}
