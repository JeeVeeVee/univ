/* EditOneMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.editdemo;

import prog2.core.FXMLMain;

/**
 * Kort demonstratieprogramma voor het editeren van tabellen. Laat toe om 9 woorden
 * in te geven, ze te editeren en ze met een druk op de knop te 'inverteren', t.t.z., achterstevoren te schrijven.<p>
 * 
 * Dit programma wordt opgebouwd in verschillende stadia. Het eerste stadium gebruikt standaard
 * getters en setters voor de velden van de rijen. Daardoor zijn de tabelcellen echter niet
 * echt editeerbaar.
 */
public class EditOneMain extends FXMLMain {
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
