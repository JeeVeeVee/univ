/* Contact.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */
package Oefeningen.ContactsGUI.DatabankAccess;

import java.util.Map;

/**
 * Bevat contactgegevens uit de 'contacts'-databank
 */
public class Contact {

    private final int id;

    public int getId() {
        return id;
    }

    private final int personId;

    public int getPersonId() {
        return personId;
    }

    private final char type;

    public char getType() {
        return type;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public Contact(int id, int personId, char type, String address) {
        this.id = id;
        this.personId = personId;
        this.type = type;
        this.address = address;
    }

    private static final Map<String, String> converter = Map.of(
            "E", "E-mail",
            "F", "FAX",
            "M", "Mobiele Telefoon",
            "T", "Vaste Telefoon"
    );

    public String getTypeString(){
        return converter.get(Character.toString(this.type));
    }

    /**
     * Conversie naar string. Om te helpen bij het testen en debuggen.
     */
    @Override
    public String toString() {
        return "[" + id + '-' + personId + ": " + type + " = " + address + "]";
    }
}
