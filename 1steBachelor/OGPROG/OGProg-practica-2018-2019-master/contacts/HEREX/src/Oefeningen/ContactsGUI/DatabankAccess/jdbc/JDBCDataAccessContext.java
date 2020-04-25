package Oefeningen.ContactsGUI.DatabankAccess.jdbc;

import Oefeningen.ContactsGUI.DatabankAccess.ContactDAO;
import Oefeningen.ContactsGUI.DatabankAccess.ContactTypeDAO;
import Oefeningen.ContactsGUI.DatabankAccess.DataAccessContext;
import Oefeningen.ContactsGUI.DatabankAccess.PersonDAO;

import java.sql.Connection;

public class JDBCDataAccessContext implements DataAccessContext {

    private Connection connection;

    public JDBCDataAccessContext(Connection connection) {
        this.connection = connection;
    }

    @Override
    public JDBCPersonDAO getPersonDAO() {
        return new JDBCPersonDAO(connection);
    }

    @Override
    public ContactDAO getContactDAO() {
        return new JDBCContactDAO(connection);
    }

    @Override
    public ContactTypeDAO getContactTyoeDAO() {
        return new JDBCContactTypeDAO(connection);
    }

    @Override
    public void close() throws Exception {

    }
}
