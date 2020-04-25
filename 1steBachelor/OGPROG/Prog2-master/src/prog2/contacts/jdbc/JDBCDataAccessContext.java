/* JDBCDataAccessContext.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.contacts.jdbc;

import prog2.contacts.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Implementatie van {@link DataAccessContext} die gebruik maakt van JDBC.
 */
class JDBCDataAccessContext implements DataAccessContext {

    // heeft geen connectie nodig en wordt daarom maar één keer aangemaakt
    private ContactTypeDAO contactTypeDAO;

    private Connection connection;

    public JDBCDataAccessContext(ContactTypeDAO contactTypeDAO, Connection connection) {
        this.contactTypeDAO = contactTypeDAO;
        this.connection = connection;
    }

    @Override
    public PersonDAO getPersonDAO() {
        return new JDBCPersonDAO(connection);
    }

    @Override
    public ContactDAO getContactDAO() {
        return new JDBCContactDAO(connection);
    }

    @Override
    public ContactTypeDAO getContactTypeDAO() {
        return contactTypeDAO;
    }

    @Override
    public PersonFinder findPersons() {
        return new JDBCPersonFinder(connection);
    }

    @Override
    public void close() throws DataAccessException {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new DataAccessException("Could not close context", ex);
        }
    }
}
