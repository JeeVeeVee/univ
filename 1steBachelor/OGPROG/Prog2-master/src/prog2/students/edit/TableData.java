/* TableData.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.students.edit;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Verzamelt alle gegevens die in de tabel getoond worden. Houdt twee modellen
 * bij: de lijst van rij-objecten en het huidige aantal gewijzigde rijen in deze
 * lijst.
 */
public class TableData {

    private IntegerProperty numberOfChanges = new SimpleIntegerProperty();

    public int getNumberOfChanges() {
        return numberOfChanges.get();
    }

    public void setNumberOfChanges(int value) {
        numberOfChanges.set(value);
    }

    public IntegerProperty numberOfChangesProperty() {
        return numberOfChanges;
    }

    private ObservableList<Row> tableModel = FXCollections.observableArrayList();

    public ObservableList<Row> getTableModel() {
        return tableModel;
    }

    /**
     * Gedeelde luisteraar die luistert naar alle changed-eigenschappen van
     * de rij-objecten.
     */
    private InvalidationListener changedPropertyListener = property -> {
        if (((BooleanProperty) property).get()) {
            numberOfChanges.set(numberOfChanges.get() + 1);
        } else {
            numberOfChanges.set(numberOfChanges.get() - 1);
        }
    };
    
    
    /**
     * Initialiseer de tabel met nieuwe gegevens.
     */

}
