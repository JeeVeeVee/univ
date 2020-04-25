package prog2.contacts.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import prog2.contacts.*;
import prog2.contacts.jdbc.JDBCDataAccessProvider;

import java.util.ResourceBundle;

public class PersonsCompanion extends DatabaseCompanion {

    public TextField textField;

    public TableView<Person> tableView;

    public TableColumn<Person, String> lastNameColumn;
    public TableColumn<Person, String> firstNameColumn;

    public TableColumn<Person, Integer> deleteButtonColumn;
    public TableColumn<Person, Integer> editButtonColumn;

    private DataAccessProvider dap = new JDBCDataAccessProvider();
    private ObservableList<Person> model = FXCollections.observableArrayList();

    private Stage newPersonDialog = new NewPersonDialog(dap, model);
    private ShowPersonDialog showPersonDialog = new ShowPersonDialog(dap, model);

    private ResourceBundle bundle = ResourceBundle.getBundle("prog2/contacts/gui/i18n");

    public void initialize() {
        tableView.setItems(model);

        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        deleteButtonColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        deleteButtonColumn.setCellFactory(DeleteButtonCell::new);

        editButtonColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        editButtonColumn.setCellFactory(EditButtonCell::new);

        tableView.setRowFactory(v -> {
            TableRow<Person> row = new TableRow<>();
            row.setOnMouseClicked(ev -> {
                if (ev.getClickCount() > 1) {
                    showPersonDialogFor(row.getIndex());
                }
            });
            return row;
        });

/*
        // Kan korter genoteerd worden als volgt. Maar is dit beter? Gebruikt 'double brace initialization' - ask Google
        tableView.setRowFactory(v -> new TableRow<>() {{
            setOnMouseClicked(ev -> {
                if (ev.getClickCount() > 1) {
                    showPersonDialogFor(getIndex());
                }
            });
        }});
*/

    }

    /**
     * Toon de lijst van personen met de gegeven naam.
     */
    public void doSearch() {
        tableView.getItems().clear();
        try (DataAccessContext dac = dap.getDataAccessContext()) {
            for (Person person : dac.getPersonDAO().findPersons(textField.getText())) {
                tableView.getItems().add(person);
            }
        } catch (DataAccessException ex) {
            signalError();
        }
    }

    /**
     * Open een venstertje waarmee een nieuwe persoon kan worden toegevoegd
     */
    public void doCreate() {
        this.newPersonDialog.show();
    }

    /**
     * Show the dialog for the person at the given row in the model
     */
    private void showPersonDialogFor(int index) {
        showPersonDialog.setPersonIndex(index);
        showPersonDialog.show();
    }

    public class DeleteButtonCell extends ButtonCell<Person> {

        public DeleteButtonCell(TableColumn<Person, Integer> notUsed) {
            button.getStyleClass().add("deleteButton");
            button.setTooltip(new Tooltip(bundle.getString("button.delete.tooltip")));
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            try (DataAccessContext dac = dap.getDataAccessContext()) {
                // verwijder uit tabel
                dac.getPersonDAO().deletePerson(getItem());

                // verwijder zichtbare rij
                tableView.getItems().remove(getIndex());
            } catch (DataAccessException dae) {
                signalError();
            }
        }
    }

    public class EditButtonCell extends ButtonCell<Person> {

        public EditButtonCell(TableColumn<Person, Integer> notUsed) {
            button.getStyleClass().add("editButton");
            button.setTooltip(new Tooltip(bundle.getString("button.edit.tooltip")));
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            showPersonDialogFor(getIndex());
        }
    }
}
