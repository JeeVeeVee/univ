/* ContactTypeDAOTest.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.contacts.test;

import prog2.contacts.ContactTypeDAO;
import prog2.contacts.DataAccessContext;
import prog2.contacts.DataAccessException;
import prog2.contacts.DataAccessProvider;
import prog2.contacts.jdbc.JDBCDataAccessProvider;

/**
 * Eenvoudig testprogramma voor {@link ContactTypeDAO}.
 */
public class ContactTypeDAOTest {
    
    private DataAccessProvider dap;

    public ContactTypeDAOTest(DataAccessProvider dap) {
        this.dap = dap;
    }

    public void run() throws DataAccessException {
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            ContactTypeDAO dao = dac.getContactTypeDAO();
            System.out.println("Het contacttype E is: " + dao.findName('E'));
            System.out.println("Alle contacttypes:");
            for (ContactTypeDAO.ContactType contactType : dao.allContactTypes()) {
                System.out.println(contactType.type +": " + contactType.name );
            }
        }
        
    }
    
    public static void main(String[] args) throws DataAccessException {
        new ContactTypeDAOTest(new JDBCDataAccessProvider()).run();
    }

    
}
