package Oefeningen.ContactsGUI.NieuwePersoon;

import Oefeningen.ContactsGUI.DatabankAccess.Person;
import Oefeningen.ContactsGUI.DatabankAccess.jdbc.JDBCDataAccessContext;
import Oefeningen.ContactsGUI.DatabankAccess.jdbc.JDBCDataAccessProvider;
import Oefeningen.ContactsGUI.DatabankAccess.jdbc.JDBCPersonDAO;
import Oefeningen.ContactsGUI.hoofdvenster.ControllerMain;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerNieuwePersoon {
    public TextField voornaam;
    public TextField familienaam;

    private JDBCDataAccessProvider dap;
    private JDBCDataAccessContext dac;
    private ControllerMain controllerMain;

    public ControllerNieuwePersoon(ControllerMain controllerMain){
        this.controllerMain = controllerMain;
        this.dap = new JDBCDataAccessProvider();
        try {
            this.dac = dap.getDataAccessContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(){
        JDBCPersonDAO personDAO = dac.getPersonDAO();
        try {
            personDAO.createPerson(new Person(0, voornaam.getText(), familienaam.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            controllerMain.search();
        } catch (Exception e) {
            e.printStackTrace();
        }
        cancel();
    }

    public void cancel(){
        Stage stage = (Stage) voornaam.getScene().getWindow();
        stage.close();
    }
}
