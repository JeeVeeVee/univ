/* StaticContactTypeDAO.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.contacts.jdbc;

import java.util.HashMap;
import java.util.Map;
import prog2.contacts.ContactTypeDAO;

/**
 * 'In memory'-implementatie van {@link ContactTypeDAO}. Veronderstelt dat de
 * contacttypegegevens niet veranderen tijdens de loop van het programma.
 */
class StaticContactTypeDAO implements ContactTypeDAO {
    
    private Iterable<ContactType> contactTypes;
    
    private Map<Character,String> map;

    public StaticContactTypeDAO(Iterable<ContactType> contactTypes) {
        this.contactTypes = contactTypes;
        this.map = new HashMap<>();
        for (ContactType contactType : contactTypes) {
            map.put (contactType.type, contactType.name);
        }
    }

    @Override
    public Iterable<ContactType> allContactTypes() {
        return contactTypes;
    }

    @Override
    public String findName(char type) {
        return map.get(type);
    }
    
}
