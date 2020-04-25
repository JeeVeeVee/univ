package prog2.contacts.gui;

import javafx.scene.control.TextField;
import prog2.contacts.Person;

public class PersonInfoCompanion {

    public TextField firstName;

    public TextField name;

    public void setPerson (Person person) {
        firstName.setText(person.getFirstName());
        name.setText(person.getName());
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getName() {
        return name.getText();
    }

    public void clear() {
        firstName.clear();
        name.clear();
    }
}
