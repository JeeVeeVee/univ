package prog2.proglangs;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.util.ArrayList;
import java.util.Collection;

import static prog2.proglangs.DAO.Preference;

/**
 * Partnerklasse voor {@link ProgLangsMain}
 */
public class ProgLangsCompanion {

    public static class Row {
        public String name;

        public BooleanProperty checkedProperty;

        public Row(Preference pref) {
            this.name = pref.name;
            this.checkedProperty = new SimpleBooleanProperty(pref.checked);
        }

    }

    public TableView<Row> tableView;

    public TableColumn<Row,String> nameColumn;
    public TableColumn<Row,Boolean> checkedColumn;

    private DAO dao;

    private ObservableList<Row> model;

    public void initialize () {

        // vul model op
        model = tableView.getItems();
        // dao = new DAOImpl1(); // of kies de onderstaande lijn
        dao = new DAOImpl2(); // of kies bovenstaande lijn
        for (Preference pref : dao.getAllPreferences()) {
            model.add(new Row(pref));
        }

        // editeerbaarheid
        tableView.setEditable(true);
        // checkedColumn.setEditable(true); // hoeft niet
        nameColumn.setEditable(false);

        // uitzicht van de tabel (omdat Row een DTO is zonder getters / setters kan je geen PropertyValueFactory gebruiken

        nameColumn.setCellValueFactory(
                features -> new SimpleStringProperty(features.getValue().name)
        );
        checkedColumn.setCellValueFactory( features ->  features.getValue().checkedProperty);
        checkedColumn.setCellFactory(column -> new CheckBoxTableCell<>());

    }

    public void updatePreferences() {
        Collection<Preference> list = new ArrayList<>(model.size());
        for (Row row : model) {
            Preference pref = new Preference();
            pref.name = row.name;
            pref.checked = row.checkedProperty.get();
            list.add(pref);
        }
        dao.updateAllPreferences(list);

        // sluit het omsluitende venster (en dus het programma)
        tableView.getScene().getWindow().hide();
    }
}
