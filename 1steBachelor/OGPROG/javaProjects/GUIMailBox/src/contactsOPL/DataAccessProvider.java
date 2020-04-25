/* DataAccessProvider.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.contacts;

/**
 * Abstractie van een databank. De enige manier om een {@link DataAccessContext} te bekomen
 * is door deze op te vragen bij een data access provider.
 */
public interface DataAccessProvider {
    
    /**
     * Geeft een data access context terug die kan gebruikt worden
     * om de databank te bevragen. Een dergelijke context moet na gebruik altijd worden gesloten.
     */

    DataAccessContext getDataAccessContext() throws DataAccessException;
    
}
