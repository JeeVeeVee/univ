/* TimeSlotTableTwoMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.tracker.table;

import prog2.core.FXMLMain;

/**
 * Laat toe om een tabel van 'time slot's aan te maken en te bewerken.
 * <p>
 * Tweede versie: gebruikt de selectie in plaats van de focus om te bepalen welke elementen mogen geëditeerd
 * worden of gewist. Dubbelklikken op een rij is ook toegelaten. Datums en tijdstippen zijn iets beter
 * geformatteerd dan in de eerste versie.
 */
public class TimeSlotTableTwoMain extends FXMLMain {

    public static void main(String[] args) {
        launch(args);
    }
}
