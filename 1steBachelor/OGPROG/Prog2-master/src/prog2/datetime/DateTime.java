/* DateTime.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.datetime;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

/**
 * Component waarmee datum en uur kunnen worden ingegeven. Bevat ook een 'nu'-knop die
 * datum en uur instelt op het corresponderende moment.
 */
public class DateTime extends HBox {

    private DateTimeCompanion companion;

    public DateTime() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    DateTime.class.getResource("DateTime.fxml"));
            loader.setRoot(this);
            this.companion = new DateTimeCompanion();
            loader.setController(companion);

            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception)   ;
        }

    }
    
    /**
     * Haal de datum en tijd op die door deze component wordt voorgesteld. Gebruik {@link #isValid}
     * om het verschil te detecteren tussen een ongeldige datum en een lege datum (die allebei null teruggeven).
     */
    public LocalDateTime getLocalDateTime() {
        return companion.getLocalDateTime();
    }
    
    /**
     * Zijn de datum en tijd die werden ingetikt wel geldig? Enkel gebruiken onmiddellijk na een oproep
     * van {@link #getLocalDateTime}.
     */
    public boolean isValid () {
        return companion.isValid();
    }
    
    /**
     * Stel de datum- en tijdvelden in met de gegeven datum.
     */
    public void setLocalDateTime(LocalDateTime dateTime) {
        companion.setLocalDateTime(dateTime);
    }
}
