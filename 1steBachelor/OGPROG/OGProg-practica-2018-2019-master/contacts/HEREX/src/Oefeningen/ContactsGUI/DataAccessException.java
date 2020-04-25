/* DataAccessException.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package Oefeningen.ContactsGUI;

/**
 * Wordt opgegooid wanneer er iets fout gaat met de databank.
 */
public class DataAccessException extends Exception {

    public DataAccessException(String message, Throwable th) {
        super (message, th);
    }
    
}
