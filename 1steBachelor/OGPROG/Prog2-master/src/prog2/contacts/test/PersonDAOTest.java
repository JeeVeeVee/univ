/* PersonDAOTest.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.contacts.test;

import prog2.contacts.DataAccessContext;
import prog2.contacts.DataAccessException;
import prog2.contacts.DataAccessProvider;
import prog2.contacts.Person;
import prog2.contacts.PersonDAO;
import prog2.contacts.jdbc.JDBCDataAccessProvider;

/**
 * Eenvoudig testprogramma voor {@link PersonDAO}.
 */
public class PersonDAOTest {

    private DataAccessProvider dap;

    private PersonDAOTest(DataAccessProvider dap) {
        this.dap = dap;
    }

    private void testCreateAndDeletePerson() throws DataAccessException {
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            PersonDAO dao = dac.getPersonDAO();

            int id = dao.createPerson("Janssens", "Siegfried");
            System.out.println("Persoon toegevoegd: " + id);
            dao.deletePerson(id);
            System.out.println("Persoon terug verwijderd");
        }
    }
    
    private void testFindPersons () throws DataAccessException {
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            PersonDAO dao = dac.getPersonDAO();
            
            System.out.println("Personen met de naam 'Jans...'");
            for (Person person: dao.findPersons("Jans")) {
                System.out.println(person);
            }
        }

    }
    
    private void testUpdatePerson () throws DataAccessException {
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            PersonDAO dao = dac.getPersonDAO();
            
            Person p = dao.findPersons("Vander Ven").iterator().next();
            System.out.println("Persoon met naam 'Vander Ven': " + p);
            dao.updatePerson(p.getId(), "Vanderven", p.getFirstName());
            p = dao.findPersons("Vanderven").iterator().next();
            System.out.println("Persoon heet nu 'Vanderven': " + p);
            dao.updatePerson(p.getId(), "Vander Ven", p.getFirstName());
            p = dao.findPersons("Vander Ven").iterator().next();
            System.out.println("En nu terug 'Vander Ven': " + p);
        }
    }

    private void run() throws DataAccessException {
        testCreateAndDeletePerson();
        testFindPersons();
        testUpdatePerson ();
    }

    public static void main(String[] args) throws DataAccessException {
        new PersonDAOTest(new JDBCDataAccessProvider()).run();
    }
}
