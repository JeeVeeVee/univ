/* TimeSlotTableFourMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.tracker.table;

import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DateStringConverter;
import prog2.core.FXMLMain;

/**
 * Laat toe om een tabel van 'time slot's aan te maken en te bewerken.
 * <p>
 * Vierde versie: de dubbelklikbare datumcellen zijn dit keer geïmplementeerd als
 * afgeleide klassen van {@link TextFieldTableCell} met een gepaste 
 * {@link DateStringConverter}.
 * 
 */
public class TimeSlotTableFourMain extends FXMLMain {

    public static void main(String[] args) {
        launch(args);
    }
}
