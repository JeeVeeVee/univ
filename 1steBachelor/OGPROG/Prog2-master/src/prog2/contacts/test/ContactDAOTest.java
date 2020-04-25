/* ContactDAOTest.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.contacts.test;

import prog2.contacts.Contact;
import prog2.contacts.ContactDAO;
import prog2.contacts.DataAccessContext;
import prog2.contacts.DataAccessException;
import prog2.contacts.DataAccessProvider;
import prog2.contacts.Person;
import prog2.contacts.jdbc.JDBCDataAccessProvider;

/**
 * Eenvoudig testprogramma voor {@link ContactDAO}.
 */
public class ContactDAOTest {

    private DataAccessProvider dap;

    private ContactDAOTest(DataAccessProvider dap) {
        this.dap = dap;
    }

    private void testCreateAndDeleteContact(int personId) throws DataAccessException {
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            ContactDAO dao = dac.getContactDAO();
            int contactId = dao.createContact(personId, 'E', "bramp@hotmail.com");
            System.out.println("Contact toegevoegd: " + contactId);
            dao.deleteContact(contactId);
            System.out.println("Contact verwijderd: " + contactId);
        }
    }

    private void testFindContacts(int personId) throws DataAccessException {
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            ContactDAO dao = dac.getContactDAO();

            System.out.println("Alle contactgegevens van Bram Peters");
            for (Contact contact : dao.findContacts(personId)) {
                System.out.println(contact);
            }
            System.out.println("Alle e-mailaddressen van Bram Peters");
            for (Contact contact : dao.findContactsByType(personId, 'E')) {
                System.out.println(contact);
            }
        }

    }

    private void testUpdateContact(int personId) throws DataAccessException {
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            ContactDAO dao = dac.getContactDAO();

            System.out.println("Het e-mail adres van Bram Peters wordt veranderd.");
            Contact contact = dao.findContactsByType(personId, 'E').iterator().next();
            String oldAddress = contact.getAddress();
            dao.updateContact(contact.getId(), "new.address@email.com");
            contact = dao.findContactsByType(personId, 'E').iterator().next();
            System.out.println("Dit is het resultaat : " + contact);

            System.out.println("En nu zetten we het terug op zijn oude waarde.");
            dao.updateContact(contact.getId(), oldAddress);
            contact = dao.findContactsByType(personId, 'E').iterator().next();
            System.out.println("Dit is het resultaat : " + contact);

        }
    }

    private Person getTestPerson() throws DataAccessException {
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            return dac.getPersonDAO().findPersons("Peters").iterator().next();
        }

    }

    private void run() throws DataAccessException {
        int id = getTestPerson().getId();
        testCreateAndDeleteContact(id);
        testFindContacts(id);
        testUpdateContact(id);
    }

    public static void main(String[] args) throws DataAccessException {
        new ContactDAOTest(new JDBCDataAccessProvider()).run();
    }
}
