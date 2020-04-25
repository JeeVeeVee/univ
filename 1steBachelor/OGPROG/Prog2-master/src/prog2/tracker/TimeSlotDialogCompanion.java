/* TimeSlotDialogCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.tracker;

import java.time.LocalDateTime;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import prog2.datetime.DateTime;

/**
 * Partnerklasse voor {@link TimeSlotDialog}.
 */
public class TimeSlotDialogCompanion {

    public TextField description;

    public DateTime beginDateTime;

    public DateTime endDateTime;

    public boolean okPressed = false;

    private Stage stage;

    public TimeSlotDialogCompanion(Stage stage) {
        this.stage = stage;
    }

    public void doCancel() {
        stage.close();
    }

    // worden berekend tijdens doSave en opgehaald met getTimeSlot
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    
    public void doSave() {
        // save lukt niet wanneer de tijdstippen niet geldig zijn
        this.beginDate = beginDateTime.getLocalDateTime();
        this.endDate = endDateTime.getLocalDateTime();
        if (beginDateTime.isValid() && endDateTime.isValid()) {
            okPressed = true;
            stage.close();
        }
    }

    /**
     * Het {@link TimeSlot}-object dat met deze gegevens overeenkomt, of null
     * indien ongeldig.
     */
    public TimeSlot getTimeSlot() {
        if (okPressed) {
            return new TimeSlot(beginDate, endDate, description.getText());
        } else {
            return null;
        }
    }

    public void setTimeSlot(TimeSlot ts) {
        beginDateTime.setLocalDateTime(ts.getBegin());
        endDateTime.setLocalDateTime(ts.getEnd());
        description.setText(ts.getDescription());
    }
}
