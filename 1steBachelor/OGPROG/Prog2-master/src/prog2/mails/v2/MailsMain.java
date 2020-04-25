/* MailsMain.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.mails.v2;

import prog2.core.FXMLMain;

/**
 * Toont een aantal e-mailberichten en laat toe om die op verschillende manieren te sorteren.
 *
 * Deze versie verschilt van de vorige in de volgende punten:
 * <ul>
 *     <li>Alle comparatormethoden zijn nu verzameld in een afzonderlijke klasse.</li>
 *     <li>We gebruiken een hash map om de strings uit de choice box te verbinden
 *     met de juiste comparator</li>
 * </ul>
 */
public class MailsMain extends FXMLMain {

    public static void main(String[] args) {
        launch(args);
    }

}
