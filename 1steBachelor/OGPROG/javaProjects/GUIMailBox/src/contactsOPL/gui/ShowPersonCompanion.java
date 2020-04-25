package prog2.contacts.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;
import prog2.contacts.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class ShowPersonCompanion extends DatabaseCompanion{

    private DataAccessProvider dap;
    private List<Person> parentModel; // needed for refresh in doUpdate
    private int personIndex;          //    "

    private ResourceBundle bundle = ResourceBundle.getBundle("prog2/contacts/gui/i18n");

    public PersonInfo info;

    public int personId;

    private ObservableList<ContactRow> model = FXCollections.observableArrayList();

    public TableView<ContactRow> contactTableView;

    public TableColumn<ContactRow, ContactTypeDAO.ContactType> contactTypeColumn;
    public TableColumn<ContactRow, String> addressColumn;
    public TableColumn<ContactRow, Integer> deleteButtonColumn;

    public ChoiceBox<ContactTypeDAO.ContactType> contactChoice;

    private Map<Character, ContactTypeDAO.ContactType> typeMap = new HashMap<>();

    private StringConverter<ContactTypeDAO.ContactType> contactTypeStringConverter = new StringConverter<>() {
        public String toString(ContactTypeDAO.ContactType contactType) {
            return contactType.name;
        }

        public ContactTypeDAO.ContactType fromString(String s) {
            return null; // niet gebruikt
        }
    };


    public ShowPersonCompanion(DataAccessProvider dap, List<Person> parentModel) {
        this.dap = dap;
        this.parentModel = parentModel;

        // verzamel contacttypegegevens
        try (DataAccessContext context = dap.getDataAccessContext()) {
            for (ContactTypeDAO.ContactType contactType : context.getContactTypeDAO().allContactTypes()) {
                typeMap.put (contactType.type, contactType);
            }
        } catch (DataAccessException ex) {
            signalError();
        }
    }

    public void initialize() {
        contactTableView.setItems(model);
        contactTableView.setEditable(true);

        contactTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        contactTypeColumn.setCellFactory(c -> new TextFieldTableCell<>(contactTypeStringConverter));
        contactTypeColumn.setEditable(false);

        deleteButtonColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        deleteButtonColumn.setCellFactory(DeleteButtonCell::new);
        deleteButtonColumn.setEditable(false);

        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressColumn.setCellFactory(c -> new TextFieldTableCell<>(new DefaultStringConverter())); // kan anders niet geëditeerd worden
        addressColumn.setEditable(true);
        addressColumn.setOnEditCommit(this::updateContact);

        // initializeer choice box
        contactChoice.setConverter(contactTypeStringConverter);

        for (ContactTypeDAO.ContactType contactType : typeMap.values()) {
            contactChoice.getItems().add(contactType);
        }
        contactChoice.setValue(typeMap.get('E'));

    }

    public void setPersonIndex(int index) {
        this.personIndex = index;

        // Persoonsgegevens
        Person person = parentModel.get(index);
        personId = person.getId();
        info.setPerson(person);

        // Contacten
        try (DataAccessContext context = dap.getDataAccessContext()) {
            model.clear();
            for (Contact contact : context.getContactDAO().findContacts(person.getId())) {
                ContactRow row = new ContactRow(
                        contact.getId(),
                        typeMap.get(contact.getType()),
                        contact.getAddress()
                );
                model.add(row);
            }
        } catch (DataAccessException ex) {
            signalError();
        }
    }

    public void doUpdate () {
        try (DataAccessContext context = dap.getDataAccessContext()) {
            // aanpassen in databank
            context.getPersonDAO().updatePerson(personId, info.getName(), info.getFirstName());

            // aanpassen in tabel
            parentModel.set(personIndex, new Person(personId, info.getName(), info.getFirstName()));
        } catch (DataAccessException ex) {
            signalError();
        }
    }

    public void updateContact (TableColumn.CellEditEvent<ContactRow, String> event) {
        try (DataAccessContext context = dap.getDataAccessContext()) {
            ContactRow row = event.getRowValue();
            context.getContactDAO().updateContact(row.getId(), event.getNewValue());
        } catch (DataAccessException ex) {
            signalError();
        }
    }

    public void doNewContact () {
        try (DataAccessContext context  = dap.getDataAccessContext()) {
            // maak een nieuwe contact aan met een leeg adres
            ContactTypeDAO.ContactType contactType = contactChoice.getSelectionModel().getSelectedItem();
            int contactId = context.getContactDAO().createContact(personId, contactType.type, "");
            // voeg het toe aan de tabel
            model.add(new ContactRow(contactId, contactType, "" ));
        } catch (DataAccessException ex) {
            signalError();
        }
    }

    public class DeleteButtonCell extends ButtonCell<ContactRow> {

        // Lijkt goed op DeleteButtonCell in PersonCompanion, maar dit is
        // niet zo gemakkelijk te vermijden.

        public DeleteButtonCell (TableColumn<ContactRow,Integer> notUsed) {
            button.getStyleClass().add("deleteButton");
            button.setTooltip(new Tooltip(bundle.getString("button.delete.tooltip")));
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            try (DataAccessContext dac = dap.getDataAccessContext()) {
                // verwijder uit tabel
                dac.getContactDAO().deleteContact(getItem());

                // verwijder zichtbare rij
                contactTableView.getItems().remove(getIndex());
            } catch (DataAccessException dae) {
                signalError();
            }

        }
    }


}
