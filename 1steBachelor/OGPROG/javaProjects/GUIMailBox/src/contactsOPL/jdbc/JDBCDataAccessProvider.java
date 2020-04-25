/* JDBCDataAccessProvider.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.contacts.jdbc;

import prog2.contacts.ContactTypeDAO;
import prog2.contacts.ContactTypeDAO.ContactType;
import prog2.contacts.DataAccessContext;
import prog2.contacts.DataAccessException;
import prog2.contacts.DataAccessProvider;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Implementatie van {@link DataAccessProvider} met een achterliggende JDBC
 * databank. De default databank wordt gespecificeerd in het bestand {@code database.properties} in deze
 * map, maar er kan ook een ander bestand gebruikt worden.
 */
public class JDBCDataAccessProvider implements DataAccessProvider {

    private final Properties databaseProperties;

    public JDBCDataAccessProvider(String resourceName) {
        // Ophalen van de databankgegevens
        try (InputStream inp = JDBCDataAccessProvider.class.getResourceAsStream(resourceName)) {
            databaseProperties = new Properties();
            databaseProperties.load(inp);
        } catch (IOException ex) {
            throw new RuntimeException("Could not read database properties", ex);
        }
        initContactTypes();
    }
    
    public JDBCDataAccessProvider() {
        this ("database.properties");
    }
    
    public JDBCDataAccessProvider(Properties properties) {
        this.databaseProperties = properties;
        initContactTypes ();
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
    
    // Gemeenschappelijke ContactTypeDAO voor alle contexten.
    private ContactTypeDAO contactTypeDAO;

    /**
     * Haal de lijst van contacttypes uit de databank.
     */
    private void initContactTypes() {
        List<ContactType> contactTypes = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT id,naam FROM contactcodes ORDER BY id");
                ResultSet resultSet = statement.executeQuery() ) {
            while (resultSet.next()) {
                ContactType ct = new ContactType();
                ct.type = resultSet.getString("id").charAt(0);
                ct.name = resultSet.getString ("naam");
                contactTypes.add (ct);
            }
            contactTypeDAO = new StaticContactTypeDAO(contactTypes);
        } catch (SQLException ex) {
            throw new RuntimeException("Could not prefetch contact types", ex);
        }
    }

    @Override
    public DataAccessContext getDataAccessContext() throws DataAccessException {
        try {
            return new JDBCDataAccessContext(contactTypeDAO, getConnection());
        } catch (SQLException ex) {
            throw new DataAccessException("Could not create data access context", ex);
        }
    }
}
