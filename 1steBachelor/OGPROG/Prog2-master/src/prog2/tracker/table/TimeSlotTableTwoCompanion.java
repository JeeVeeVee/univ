/* TimeSlotTableTwoCompanion.java
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
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import prog2.tracker.TimeSlot;
import prog2.tracker.TimeSlotDialog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Partnerklasse voor {@code TimeSlotTableTwo.fxml}
 */
public class TimeSlotTableTwoCompanion implements InvalidationListener, EventHandler<ActionEvent> {

    public TableView<TimeSlot> tableView;

    public TableColumn<TimeSlot, String> beginColumn;

    public TableColumn<TimeSlot, String> endColumn;

    public TableColumn<TimeSlot, String> descriptionColumn;

    public Button editButton;

    public Button deleteButton;

    private MultipleSelectionModel<TimeSlot> selectionModel;

    private TimeSlotDialog dialog;

    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

    public void initialize() {

        // 
        selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        selectionModel.getSelectedIndices().addListener(this);
        invalidated(null); // disable the delete- en edit-knoppen

        dialog = new TimeSlotDialog();

        // TODO: gebruik nog minder copy and paste
        beginColumn.setCellValueFactory(
            f -> {
                LocalDateTime date = f.getValue().getBegin();
                if (date != null) {
                    return new ReadOnlyStringWrapper(DATE_TIME_FORMATTER.format(date));
                } else {
                    return null;
                }
            });
        endColumn.setCellValueFactory(
            f -> {
                LocalDateTime date = f.getValue().getEnd();
                if (date != null) {
                    return new ReadOnlyStringWrapper(DATE_TIME_FORMATTER.format(date));
                } else {
                    return null;
                }
            });
        descriptionColumn.setCellValueFactory(
                new PropertyValueFactory<>("description"));

        // beter duplicatie vermijden in onderstaande drie opdrachten
        //   gebruik ctrl-alt-V in IntelliJ IDEA om parametertype niet te moeten onthouden of opzoeken
        beginColumn.setCellFactory(t -> new DoubleClickableTableCell<>(this));
        endColumn.setCellFactory(t -> new DoubleClickableTableCell<>(this));
        descriptionColumn.setCellFactory(t -> new DoubleClickableTableCell<>(this));
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

    public void editTimeSlot(int index) {
        if (index >= 0 && index < tableView.getItems().size()) {
            dialog.setTitle("Record wijzigen");
            dialog.setTimeSlot(tableView.getItems().get(index));
            dialog.showAndWait();
            TimeSlot ts = dialog.getTimeSlot();
            if (ts != null) {
                tableView.getItems().set(index, ts);
            }
        }
    }

    public void doEdit() {
        editTimeSlot(selectionModel.getSelectedIndices().get(0));

    }

    public void doDelete() {
        // opgelet: selected indices staan niet in volgorde, daarom
        // nemen we de volgende gemakkelijkheidsoplossing:
        for (TimeSlot slot : new ArrayList<>(selectionModel.getSelectedItems())) {
            tableView.getItems().remove(slot);
        }
     }

    @Override
    public void invalidated(Observable observable) {
        int count = selectionModel.getSelectedIndices().size();
        deleteButton.setDisable(count <= 0);
        editButton.setDisable(count != 1);
    }

    /**
     * Wordt opgeroepen wanneer er wordt gedubbelklikt op een rij.
     */
    @Override
    public void handle(ActionEvent t) {
        editTimeSlot(((TableCell) t.getSource()).getIndex());
    }


}
