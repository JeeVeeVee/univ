/* EditMarksCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.students.edit;

import java.sql.SQLException;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Partnerklasse voor {@code EditMarks.fxml}
 */
public class EditMarksCompanion implements InvalidationListener {

    public TextField textField;

    public Label title;

    public Button searchButton;

    public Button saveButton;

    public Button cancelButton;

    public TableView<Row> tableView;

    public TableColumn<Row, String> lastNameColumn;

    public TableColumn<Row, String> firstNameColumn;

    public TableColumn<Row, Integer> marksColumn;

    private TableData tableData;



    public void initialize() {


        tableData = new TableData();
        tableData.numberOfChangesProperty().addListener(this);

        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setEditable(false);

        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setEditable(false);

        marksColumn.setCellValueFactory(new PropertyValueFactory<>("marks"));


        marksColumn.setEditable(true);

        tableView.setItems(tableData.getTableModel());
        tableView.setEditable(true); // niet vergeten

        tableView.setRowFactory(table -> new MarksTableRow());

    }

    public void doSearch() throws SQLException {

    }

    /**
     * Slaat de lijst op in de databank.
     */
    public void doSave() throws SQLException {

    }

    /**
     * Annuleert de veranderingen
     */
    public void doCancel(){
    }

    /**
     * Reageert op veranderingen in het aantal wijzigingen
     */
    @Override
    public void invalidated(Observable o) {

    }


}
