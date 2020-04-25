package prog2.proglangs;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static prog2.proglangs.DAO.Preference;

/**
 * Partnerklasse voor {@link ProgLangsSimpleMain}
 */
public class ProgLangsSimpleCompanion {


    public TableView<Preference> tableView;

    public TableColumn<Preference,String> nameColumn;
    public TableColumn<Preference,Boolean> checkedColumn;

    private ObservableList<Preference> model;

    public void initialize () {

        // vul model op
        model = tableView.getItems();
        // model.addAll(new DAOImpl1().getAllPreferences());  // of kies onderstaande lijn
        model.addAll(new DAOImpl2().getAllPreferences());     // of kies bovenstaande lijn

        nameColumn.setCellValueFactory(
                features -> new SimpleStringProperty(features.getValue().name)
        );
        checkedColumn.setCellValueFactory(
                features ->  new SimpleBooleanProperty(features.getValue().checked)
        );
    }

    public void updatePreferences() {
        // Doet geen update - sluit enkel het venster
        tableView.getScene().getWindow().hide();
    }
}
