/* Windrichting.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.extra;

import java.util.EnumMap;
import java.util.Map;

/**
 * Voorbeeld van een opsomtype met velden.
 */
public enum Windrichting {

    OOST("Subsolanus"),
    ZUID("Auster"),
    WEST("Favonius"),
    NOORD("Septentrio");

    private String latijnseNaam;

    Windrichting (String latijnseNaam) {
        this.latijnseNaam = latijnseNaam;
    }

    public String getLatijnseNaam() {
        return this.latijnseNaam;
    }

    public static void voorbeeld() {
        Map<Windrichting, String> map = new EnumMap<>(Windrichting.class);

        map.put(Windrichting.OOST, "Est");
        map.put(Windrichting.ZUID, "Sud");
        map.put(Windrichting.WEST, "Ouest" );
        map.put(Windrichting.NOORD, "Nord");
    }

    public static void main(String[] args) {
        System.out.println ("Alle windrichtingen - Nederlands & Latijn");
        for (Windrichting richting : Windrichting.values()) {
            System.out.println(richting);
            System.out.println(richting.getLatijnseNaam());
        }
    }
}