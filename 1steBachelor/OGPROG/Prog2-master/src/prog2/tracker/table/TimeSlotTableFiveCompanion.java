/* TimeSlotTableFiveCompanion.java
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.LocalDateTimeStringConverter;
import prog2.tracker.TimeSlot;
import prog2.tracker.TimeSlotDialog;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static prog2.tracker.table.TimeSlotTableTwoCompanion.DATE_TIME_FORMATTER;

/**
 * Partnerklasse voor {@code TimeSlotTableFive.fxml}
 */
public class TimeSlotTableFiveCompanion implements InvalidationListener {

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

        //
        beginColumn.setCellValueFactory( new PropertyValueFactory<>("begin"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        Callback<TableColumn<TimeSlot, LocalDateTime>, TableCell<TimeSlot, LocalDateTime>> cellFactory =
                table -> new TextFieldTableCell<>(
                                new LocalDateTimeStringConverter(DATE_TIME_FORMATTER, DATE_TIME_FORMATTER)
                );
        beginColumn.setCellFactory(cellFactory);
        endColumn.setCellFactory(cellFactory);

        tableView.setRowFactory(table -> new DoubleClickableTableRow<>(
                ev-> editTimeSlot(((TableRow)ev.getSource()).getIndex()) )
        );
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
}
