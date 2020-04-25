/* EditOneCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.editdemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * Partnerklasse voor {@code EditOne.fxml}
 */
public class EditOneCompanion {

    public static String reverse(String src) {
        StringBuilder str = new StringBuilder(src.length());
        for (int i = src.length() - 1; i >= 0; i--) {
            str.append(src.charAt(i));
        }
        return str.toString();
    }

    public static class Row {

        private int index;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        private String contents;

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public Row(int index, String contents) {
            this.index = index;
            this.contents = contents;
        }

        @Override
        public String toString() {
            return index + ": " + contents;
        }
        
        public void reverseContents () {
            contents = reverse(contents);
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
        indexColumn.setEditable(false); // niet nodig bij de default cell factory

        contentsColumn.setCellValueFactory(new PropertyValueFactory<>("contents"));
        contentsColumn.setEditable(true); // niet nodig
        contentsColumn.setCellFactory(list -> new TextFieldTableCell<>()); // default laat geen edit toe!
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
