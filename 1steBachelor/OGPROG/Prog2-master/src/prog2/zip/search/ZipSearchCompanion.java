/* ZipSearchCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.zip.search;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Partnerklasse voor {@code ZipSearch.fxml}
 */
public class ZipSearchCompanion {

    public TextField searchField;

    public TableView<ZipInfo> tableView;

    public TableColumn<ZipInfo, String> zipColumn;

    public TableColumn<ZipInfo, String> nameColumn;

    public ZipSearcher zipSearcher;

    public void initialize() {
        zipColumn.setCellValueFactory( new PropertyValueFactory<>("zip") );
        nameColumn.setCellValueFactory( new PropertyValueFactory<>("name") );

        zipSearcher = new ZipSearcher();
    }

    public void doSearch() {
        ObservableList<ZipInfo> model = FXCollections.observableArrayList();
        for (ZipInfo zipInfo : zipSearcher.find(searchField.getText())) {
            model.add(zipInfo);
        }
        tableView.setItems(model);
    }
}
