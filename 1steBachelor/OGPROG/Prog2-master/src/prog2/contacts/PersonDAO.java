/* PersonDAO.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.contacts;

/**
 * Laat toe om persoonsgegevens op te zoeken, aan te maken, te wijzigen of te wissen.
 */
public interface PersonDAO {
    
    /**
     * Creëer een nieuwe persoon met de gegeven familienaam en voornaam.
     * @return De id van de nieuwe aangemaakte persoon
     */
    int createPerson(String name, String firstName) throws DataAccessException;
    
    /**
     * Pas de persoonsgegevens aan in de databank.
     */
    void updatePerson(int id, String name, String firstName) throws DataAccessException;
    
    /**
     * Verwijder de persoon met opgegeven id uit de databank.
     */
    void deletePerson(int id) throws DataAccessException;

    /**
     * Geef een lijst terug van alle personen waarvan de familienaam begint met de
     * gegeven prefix.
     */
    Iterable<Person> findPersons(String namePrefix) throws DataAccessException;

}
