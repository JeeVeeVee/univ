/* DateTimeTesterCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.datetime;

import javafx.scene.control.Label;

import java.time.LocalDateTime;

/**
 * Partnerklasse voor {@code DateTimeTester.fxml}.
 */
public class DateTimeTesterCompanion {

    public Label dateLabel;

    public DateTime dateTime;

    public void showDate() {
        LocalDateTime date = dateTime.getLocalDateTime();
        if (date == null) {
            if (dateTime.isValid()) {
                dateLabel.setText("null");
            } else {
                dateLabel.setText("???");
            }
        } else {
            dateLabel.setText(date.toString());
        }
    }
}
