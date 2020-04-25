/* DataAccessContext.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.contacts;

/**
 * Deze data access context geeft ons toegang tot de verschillende
 * data access objects. Deze context moet gesloten worden nadat hij is gebruikt.
 */
public interface DataAccessContext extends AutoCloseable {
    
    PersonDAO getPersonDAO();
    
    ContactDAO getContactDAO();
    
    ContactTypeDAO getContactTypeDAO();

    PersonFinder findPersons(); // voorbeeld van het gebruik van een 'fluent' API
    
    @Override
    void close() throws DataAccessException;
    
}
