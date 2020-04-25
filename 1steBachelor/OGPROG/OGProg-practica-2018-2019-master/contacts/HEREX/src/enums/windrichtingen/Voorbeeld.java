/* Windrichting.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */
package enums.windrichtingen;

import java.util.EnumMap;
import java.util.Map;

/**
 * Voorbeeld van een opsomtype met velden.
 */
public enum Voorbeeld {

    OOST("Subsolanus"),
    ZUID("Auster"),
    WEST("Favonius"),
    NOORD("Septentrio");

    private String latijnseNaam;

    Voorbeeld (String latijnseNaam) {
        this.latijnseNaam = latijnseNaam;
    }

    public String getLatijnseNaam() {
        return this.latijnseNaam;
    }

    public static void voorbeeld() {
        Map<Voorbeeld, String> map = new EnumMap<>(Voorbeeld.class);

        map.put(Voorbeeld.OOST, "Est");
        map.put(Voorbeeld.ZUID, "Sud");
        map.put(Voorbeeld.WEST, "Ouest" );
        map.put(Voorbeeld.NOORD, "Nord");
    }

    public static void main(String[] args) {
        System.out.println ("Alle windrichtingen - Nederlands & Latijn");
        for (Voorbeeld richting : Voorbeeld.values()) {
            System.out.println(richting);
            System.out.println(richting.getLatijnseNaam());
        }
    }
}