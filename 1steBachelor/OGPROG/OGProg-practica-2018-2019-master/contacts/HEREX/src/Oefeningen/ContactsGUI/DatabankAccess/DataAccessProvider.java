package Oefeningen.ContactsGUI.DatabankAccess;

public interface DataAccessProvider {
    public DataAccessContext getDataAccessContext() throws Exception;
}
