/* TimeSlotTableThreeCompanion.java
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import prog2.tracker.TimeSlot;
import prog2.tracker.TimeSlotDialog;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static prog2.tracker.table.TimeSlotTableTwoCompanion.DATE_TIME_FORMATTER;

/**
 * Partnerklasse voor {@code TimeSlotTableThree.fxml}
 */
public class TimeSlotTableThreeCompanion implements InvalidationListener, EventHandler<ActionEvent> {

    public TableView<TimeSlot> tableView;

    public TableColumn<TimeSlot, LocalDateTime> beginColumn;

    public TableColumn<TimeSlot, LocalDateTime> endColumn;

    public TableColumn<TimeSlot, String> descriptionColumn;

    public Button editButton;

    public Button deleteButton;

    private MultipleSelectionModel<TimeSlot> selectionModel;

    private TimeSlotDialog dialog;

    public void initialize() {

        // 
        selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        selectionModel.getSelectedIndices().addListener(this);
        invalidated(null); // disable the delete- en edit-knoppen

        dialog = new TimeSlotDialog();

        //  Merk op dat de eerste twee kolommen als type LocalDateTime hebben en niet meer String
        beginColumn.setCellValueFactory( new PropertyValueFactory<>("begin"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
        descriptionColumn.setCellValueFactory( new PropertyValueFactory<>("description"));

        Callback<TableColumn<TimeSlot, LocalDateTime>, TableCell<TimeSlot, LocalDateTime>> dateTimeCellFactory
                = t -> new DateColumnCell();
        beginColumn.setCellFactory(dateTimeCellFactory);
        endColumn.setCellFactory(dateTimeCellFactory);

        descriptionColumn.setCellFactory(table -> {
            TextFieldTableCell<TimeSlot,String> cell = new TextFieldTableCell<>();
            cell.setOnMouseClicked( event ->  {
                if (event.getClickCount() > 1) {
                    editTimeSlot(cell.getIndex());
                }
            });
            return cell;
        });
    }

    private class DateColumnCell extends DoubleClickableTableCell<TimeSlot,LocalDateTime> {

        public DateColumnCell() {
            super(TimeSlotTableThreeCompanion.this);
        }

        @Override
        public void updateItem(LocalDateTime date, boolean empty) {
            super.updateItem(date, empty);
            if (empty) {
                setText(null);
            } else {
                setText(DATE_TIME_FORMATTER.format(date));     // note: static import
            }
        }
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
        TableCell tc = (TableCell) t.getSource();
        editTimeSlot(tc.getIndex());
    }
}
