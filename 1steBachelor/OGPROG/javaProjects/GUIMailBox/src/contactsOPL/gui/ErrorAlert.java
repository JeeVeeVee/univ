package prog2.contacts.gui;

import javafx.scene.control.Alert;

import java.util.ResourceBundle;

public class ErrorAlert extends Alert {

    public ErrorAlert (String key) {
        super (AlertType.ERROR);
        ResourceBundle bundle = ResourceBundle.getBundle("prog2/contacts/gui/i18n");
        setContentText(bundle.getString(key));
        String title = bundle.getString(key + ".title");
        setTitle(title);
        setHeaderText(title);
    }
}
