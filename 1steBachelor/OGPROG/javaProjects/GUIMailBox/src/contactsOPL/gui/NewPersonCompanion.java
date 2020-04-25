package prog2.contacts.gui;

import prog2.contacts.*;

import java.util.List;

public class NewPersonCompanion extends DatabaseCompanion {

    private DataAccessProvider dap;
    private List<Person> model;

    public NewPersonCompanion(DataAccessProvider dap, List<Person> model) {
        this.dap = dap;
        this.model = model;
    }

    public PersonInfo info;

    private void closeWindow () {
        info.getScene().getWindow().hide();
        info.clear();
    }

    public void doSubmit () {
        try (DataAccessContext dac = dap.getDataAccessContext()){
            int id = dac.getPersonDAO().createPerson(
                    info.getName(), info.getFirstName()
            );
            // toon in GUI
            model.add(new Person(id, info.getName(), info.getFirstName()));
        } catch (DataAccessException ex) {
            signalError();
        }
        closeWindow();
    }

    public void doCancel () {
        closeWindow();
    }
}
