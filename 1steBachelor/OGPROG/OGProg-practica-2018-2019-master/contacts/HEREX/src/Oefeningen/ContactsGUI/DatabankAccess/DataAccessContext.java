package Oefeningen.ContactsGUI.DatabankAccess;

public interface DataAccessContext extends AutoCloseable {
    PersonDAO getPersonDAO();
    ContactDAO getContactDAO();
    ContactTypeDAO getContactTyoeDAO();
    void close() throws Exception;
}
