package Oefeningen.ContactsGUI.DatabankAccess;

import java.sql.*;


public interface ContactDAO {

    int createContact(int personID, char code, String address) throws Exception;

    void updateContact(int id, String address) throws Exception;

    void deleteContact(int id) throws Exception;

    Iterable<Contact> findContacts(int personID) throws Exception;

    Iterable<Contact> findContactsByType (int personID, char type) throws Exception;
}
