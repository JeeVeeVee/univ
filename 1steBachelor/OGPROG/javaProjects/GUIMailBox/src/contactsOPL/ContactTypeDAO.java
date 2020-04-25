/* ContactTypeDAO.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.contacts;

/**
 * Eenvoudig data access object waarmee de verschillende contacttypes kunnen
 * worden opgevraagd.
 */
public interface ContactTypeDAO {

    /**
     * Geef de naam terug die correspondeert met het opgegeven type.
     */
    String findName(char type) throws DataAccessException;

    /**
     * DTO voor {@link #allContactTypes()}
     */
    class ContactType {
        public char type;
        public String name;
    }

    /**
     * Geef een lijst terug van alle bestaande contacttypes (en hun naam)
     */
    Iterable<ContactType> allContactTypes() throws DataAccessException;
}
