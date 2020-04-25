/* DateTimeCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.datetime;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.time.DateTimeException;
import java.time.LocalDateTime;

/**
 * Partnerklasse voor {@code DateTime.fxml}.
 */
public class DateTimeCompanion {

    public HBox hbox;

    public TextField year;

    public TextField month;

    public TextField day;

    public TextField hours;

    public TextField minutes;

    private TextField[] textFields;

    /**
     * Geeft aan of de laatste oproep van {@link #getLocalDateTime} een geldige datum en
     * tijd voorstelde. Wanneer alle velden leeg zijn, wordt dit ook als geldig
     * beschouwd. <p>Wordt automatisch terug true wanneer de inhoud van de
     * tekstvelden wijzigt.
     */
    private boolean valid;
    // beter is om hier het MVC-patroon toe te passen en van valid een Boolean property te maken

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
        if (valid) {
            hbox.getStyleClass().removeAll("invalid");
        } else {
            hbox.getStyleClass().add("invalid");
        }
    }

    public void initialize() {

        textFields = new TextField[] {
                year, month, day, hours, minutes
        };

        for (TextField field : textFields) {
            field.textProperty().addListener(o -> setValid(true));
        }
    }

    /**
     * Reageer op de knop door het huidige tijdstip in de velden in te vullen.
     */
    public void nowPushed() {
        setLocalDateTime(LocalDateTime.now());
    }

    /**
     * Pas de velden aan zodat ze de opgegeven datum tonen.
     */
    public void setLocalDateTime(LocalDateTime dateTime) {

        if (dateTime == null) {
            year.clear();
            month.clear();
            day.clear();

            hours.clear();
            minutes.clear();
        } else {
            year.setText(Integer.toString(dateTime.getYear()));
            month.setText(Integer.toString(dateTime.getMonthValue()));
            day.setText(Integer.toString(dateTime.getDayOfMonth()));

            hours.setText(Integer.toString(dateTime.getHour()));
            minutes.setText(Integer.toString(dateTime.getMinute()));
        }
    }

    private boolean isCompletelyEmpty() {
        int i = textFields.length - 1;
        while (i >= 0 && textFields[i].getText().trim().isEmpty()) {
            i --;
        }
        return i < 0;
    }

    /**
     * Converteert de inhoud van de tekstvelden naar een datum en tijd. Maakt
     * {@link #valid} true of false naargelang dit is gelukt of niet.
     *
     * @return Corresponderende datum of null wanneer leeg of niet geldig.
     */
    public LocalDateTime getLocalDateTime() {

        // een volledig lege datum is ook correct
        if (isCompletelyEmpty()) {
            setValid(true);
            return null;
        }

        try {
            LocalDateTime dateTime = LocalDateTime.of(
                    Integer.parseInt(year.getText().trim()),
                    Integer.parseInt(month.getText().trim()),
                    Integer.parseInt(day.getText().trim()),
                    Integer.parseInt(hours.getText().trim()),
                    Integer.parseInt(minutes.getText().trim())
            );
            setValid(true);
            return dateTime;
        } catch (IllegalArgumentException | DateTimeException ex) {
            setValid(false);
            return null;
        }
    }
}
