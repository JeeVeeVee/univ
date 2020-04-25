/* TimeSlotTableOneCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.tracker.table;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import prog2.tracker.TimeSlot;
import prog2.tracker.TimeSlotDialog;

import java.time.LocalDateTime;


/**
 * Partnerklasse voor {@code TimeSlotTableOne.fxml}
 */
public class TimeSlotTableOneCompanion implements InvalidationListener {

    public TableView<TimeSlot> tableView;

    public TableColumn<TimeSlot, LocalDateTime> beginColumn;

    public TableColumn<TimeSlot, LocalDateTime> endColumn;

    public TableColumn<TimeSlot, String> descriptionColumn;

    public Button editButton;

    public Button deleteButton;

    private FocusModel<TimeSlot> focusModel;

    private TimeSlotDialog dialog;

    public void initialize() {

        // 
        focusModel = tableView.getFocusModel();
        focusModel.focusedIndexProperty().addListener(this);
        invalidated(null); // disable the delete- en edit-knoppen

        dialog = new TimeSlotDialog();

        //
        beginColumn.setCellValueFactory( new PropertyValueFactory<>("begin"));
        endColumn.setCellValueFactory( new PropertyValueFactory<>("end"));
        descriptionColumn.setCellValueFactory( new PropertyValueFactory<>("description"));

        // onderstaande kan ook rechtstreeks in het FXML-bestand
        // zie versie 2 voor een voorbeeld

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Label label = new Label("<leeg>");
        label.setId("placeHolder"); // ten behoeve van de CSS
        tableView.setPlaceholder(label);
    }

    public void doAdd() {
        TimeSlot ts = TimeSlot.emptyNow();
        dialog.setTimeSlot(ts);
        dialog.setTitle("Nieuw record toevoegen");
        dialog.showAndWait();
        ts = dialog.getTimeSlot();
        if (ts != null) {
            tableView.getItems().add(ts);
        }
    }

    public void doEdit() {
        int index = focusModel.getFocusedIndex();
        if (index >= 0) {
            dialog.setTitle("Record wijzigen");
            dialog.setTimeSlot(tableView.getItems().get(index));
            dialog.showAndWait();
            TimeSlot ts = dialog.getTimeSlot();
            if (ts != null) {
                tableView.getItems().set(index, ts);
            }
        }
    }

    public void doDelete() {
        int focusedIndex = focusModel.getFocusedIndex();
        if (focusedIndex >= 0) {
            tableView.getItems().remove(focusedIndex);
        }
    }

    @Override
    public void invalidated(Observable observable) {
        boolean nothingFocused = focusModel.getFocusedIndex() < 0;
        deleteButton.setDisable(nothingFocused);
        editButton.setDisable(nothingFocused);
    }
}
