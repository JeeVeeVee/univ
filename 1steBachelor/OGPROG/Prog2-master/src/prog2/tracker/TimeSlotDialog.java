/* TimeSlotDialog.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.tracker;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Dialoog waarmee je een {@link TimeSlot} kan intikken of editeren. Dit doe je met de volgende
 * stappen:
 * <ul>
 * <li>Maak een dialoogobject aan.</li>
 * <li>Vul de gegevens in met behulp van {@link #setTimeSlot}.</li>
 * <li>Toon de dialoog met {@link #showAndWait}.</li>
 * <li>Haal de nieuwe waarde op met {@link #getTimeSlot}.</li>
 * </ul>
 */
public class TimeSlotDialog extends Stage {
    
    // opmerking: als alternatief hadden we ervoor kunnen kiezen 
    // het TimeSlotDialog-object zelf als partnerklasse te gebruiken
    // in plaats van alles naar companion te delegeren
    private TimeSlotDialogCompanion companion;

    public TimeSlotDialog()  {
        super (StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        try {
            FXMLLoader loader = new FXMLLoader(TimeSlotDialog.class.getResource("TimeSlotDialog.fxml"));
            this.companion = new TimeSlotDialogCompanion(this);
            loader.setController (companion);
            Parent root = loader.load();
            setScene (new Scene(root));
        } catch (IOException ex) {
            throw new RuntimeException ("Could not create dialog", ex);
        }
    }

    @Override
    public void showAndWait() {
        companion.okPressed = false;
        super.showAndWait();
    }
    
    
        
    /**
     * Stel de gegevens in die door deze dialoog moeten getoond worden.
     */
    public void setTimeSlot (TimeSlot ts) {
        companion.setTimeSlot(ts);
    }
    
    /**
     * Haalt de gegevens op die door de gebruiker zijn ingevuld.
     * @return null wanneer de gebruiker de dialoog heeft geannuleerd
     */
    public TimeSlot getTimeSlot () {
        return companion.getTimeSlot();
    }
    
}
