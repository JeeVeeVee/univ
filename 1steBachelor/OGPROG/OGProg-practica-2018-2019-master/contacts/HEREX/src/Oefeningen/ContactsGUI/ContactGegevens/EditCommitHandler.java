package Oefeningen.ContactsGUI.ContactGegevens;

import Oefeningen.ContactsGUI.DatabankAccess.Contact;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;

public class EditCommitHandler implements EventHandler<TableColumn.CellEditEvent<Contact, String>> {
    @Override
    public void handle(TableColumn.CellEditEvent<Contact, String> contactStringCellEditEvent) {
        Contact contact = contactStringCellEditEvent.getRowValue();

    }
}
