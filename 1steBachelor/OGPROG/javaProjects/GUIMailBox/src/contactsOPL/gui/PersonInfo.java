package prog2.contacts.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import prog2.contacts.Person;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Nieuwe component met een veld voor voornaam en familienaam
 */
public class PersonInfo extends GridPane {

    private PersonInfoCompanion companion;

    public PersonInfo() throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("prog2/contacts/gui/i18n");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonInfo.fxml"), bundle);
        loader.setRoot(this);
        loader.load();
        this.companion = loader.getController();
    }

    public void setPerson(Person person) {
        companion.setPerson(person);
    }

    public String getFirstName() {
        return companion.getFirstName();
    }

    public String getName() {
        return companion.getName();
    }

    public void clear() {
        companion.clear();
    }
}
