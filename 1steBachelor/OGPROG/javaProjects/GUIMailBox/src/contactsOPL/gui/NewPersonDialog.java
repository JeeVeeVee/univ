package prog2.contacts.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import prog2.contacts.DataAccessProvider;
import prog2.contacts.Person;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class NewPersonDialog extends Stage {

    public NewPersonDialog(DataAccessProvider dap, List<Person> model) {
        super(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("prog2/contacts/gui/i18n");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewPerson.fxml"), bundle);
            loader.setController(new NewPersonCompanion(dap, model));
            Parent parent = loader.load();
            setScene(new Scene(parent));
            setTitle(bundle.getString("dialog.new.person.title"));
        } catch (IOException e) {
            throw new RuntimeException("Could not create NewPersonDialog", e);
        }
    }

}
