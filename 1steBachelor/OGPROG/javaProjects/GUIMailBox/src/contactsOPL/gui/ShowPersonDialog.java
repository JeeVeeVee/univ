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

public class ShowPersonDialog extends Stage {

    private ShowPersonCompanion companion;

    public ShowPersonDialog(DataAccessProvider dap, List<Person> parentModel)   {
        super (StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("prog2/contacts/gui/i18n");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowPerson.fxml"), bundle);
            companion = new ShowPersonCompanion(dap, parentModel);
            loader.setController(companion);
            Parent parent = loader.load();
            setScene(new Scene(parent));
            setTitle(bundle.getString("dialog.show.person.title"));
        } catch (IOException e) {
            throw new RuntimeException("Could not create ShowPersonDialog", e);
        }
    }

    public void setPersonIndex (int index) {
        companion.setPersonIndex(index);
    }

}
