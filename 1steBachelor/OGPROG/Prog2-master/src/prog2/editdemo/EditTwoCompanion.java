/* EditTwoCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.editdemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 * Partnerklasse voor {@code EditTwo.fxml}
 */
public class EditTwoCompanion {

    public static class Row {

        private int index;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        private StringProperty contents;
        
        public StringProperty contentsProperty() {
            return this.contents;
        }

        public Row(int index, String contents) {
            this.index = index;
            this.contents = new SimpleStringProperty(contents);
        }

        @Override
        public String toString() {
            return index + ": " + contents.get();
        }
        
        public void reverseContents () {
            contents.set (EditOneCompanion.reverse(contents.get()));
        }
    }

    public TableColumn<Row, Integer> indexColumn;

    public TableColumn<Row, String> contentsColumn;

    public TableView<Row> table;

    private ObservableList<Row> model;

    private static final String[] WORDS = {"alfa", "papa", "tango", "hotel", "charlie", "mango", "delta", "foxtrot", "zen"};

    public void initialize() {
        model = FXCollections.observableArrayList();
        for (int i = 0; i < WORDS.length; i++) {
            model.add(new Row(i + 1, WORDS[i]));
        }
        table.setEditable(true);
        table.setItems(model);

        indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));
        
        // onderstaande laat toe om ook de indexen te editeren - zonder veel gevolg echter
        indexColumn.setCellFactory(column -> new TextFieldTableCell<>(new IntegerStringConverter()));

        contentsColumn.setCellValueFactory(new PropertyValueFactory<Row, String>("contents"));
        contentsColumn.setCellFactory(column -> new TextFieldTableCell<>());

    }


    public void doReverse() {
        for (Row row : model) {
            row.reverseContents ();
        }
    }

    public void doPrint() {
        System.out.println("==============================");
        for (Row row : model) {
            System.out.println(row);
        }
        System.out.println("==============================\n");
    }
}
