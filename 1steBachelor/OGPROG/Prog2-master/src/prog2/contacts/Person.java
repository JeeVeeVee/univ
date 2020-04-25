/* Person.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.contacts;

/**
 * Bevat de gegevens van een persoon uit de 'contacts'-databank.
 */
public class Person {

    private final int id;

    public int getId() {
        return id;
    }

    private final String name;

    public String getName() {
        return name;
    }

    private final String firstName;

    public String getFirstName() {
        return firstName;
    }

    public Person(int id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
    }

    /**
     * Conversie naar string. Om te helpen bij het testen en debuggen.
     */
    @Override
    public String toString() {
        return "[" + id + ": " + name + ", " + firstName + "]";
    }
}
