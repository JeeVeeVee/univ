/* TimeSlotDialogTesterCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.tracker;

import javafx.scene.control.Label;

import java.time.LocalDateTime;

/**
 * Partnerklasse van {@code TimeSlotDialogTester.fxml}
 */
public class TimeSlotDialogTesterCompanion {
    
    public Label result;
    
    private TimeSlotDialog dialog;
    
    public void initialize () {
        dialog = new TimeSlotDialog ();
        LocalDateTime dateTime = LocalDateTime.now();
        dialog.setTimeSlot(new TimeSlot(
                dateTime.minusHours(50),
                dateTime,
                "Testing dialog"
                ));
    }
    
    public void showDialog () {
        dialog.showAndWait();
        TimeSlot ts = dialog.getTimeSlot();
        if (ts == null) {
            result.setText("<canceled>");
        } else {
            result.setText (ts.toString());
        }
    }
    
}
