/* ContactDAO.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.contacts;

/**
 * Laat toe om contactgegevens op te zoeken, aan te maken, te wijzigen of te verwijderen.
 */
public interface ContactDAO {
    
    /**
     * Voeg nieuwe contactgegevens toe voor de opgegeven persoon.
     * @param code éénlettercode die het type bepaalt van dit contact
     */
    int createContact(int personId, char code, String address) throws DataAccessException;
    
    /**
     * Pas in de databank het adres aan van het opgegeven contact
     */
    void updateContact(int id, String address) throws DataAccessException;
    
    /**
     * Verwijder de contactinformatie uit de databank voor het contact met de opgegeven identificatie
     */
    void deleteContact(int id) throws DataAccessException;
    
    /**
     * Geef alle contactinformatie terug voor de persoon met de gegeven identificatie
     */
    Iterable<Contact> findContacts(int personId) throws DataAccessException;
    
    /**
     * Geef alle contactinformatie terug voor de persoon met de gegeven identificatie, beperkt
     * tot het opgegeven type.
     */
    Iterable<Contact> findContactsByType(int personId, char type) throws DataAccessException;
    
    
}
