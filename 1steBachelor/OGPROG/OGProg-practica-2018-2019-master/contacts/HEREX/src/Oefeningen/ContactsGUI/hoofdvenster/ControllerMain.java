package Oefeningen.ContactsGUI.hoofdvenster;

import Oefeningen.ContactsGUI.ContactGegevens.ContactGegevens;
import Oefeningen.ContactsGUI.DatabankAccess.DataAccessContext;
import Oefeningen.ContactsGUI.DatabankAccess.DataAccessProvider;
import Oefeningen.ContactsGUI.DatabankAccess.Person;
import Oefeningen.ContactsGUI.DatabankAccess.PersonDAO;
import Oefeningen.ContactsGUI.DatabankAccess.jdbc.JDBCDataAccessProvider;
import Oefeningen.ContactsGUI.ButtonCell;
import Oefeningen.ContactsGUI.ImageButton;
import Oefeningen.ContactsGUI.NieuwePersoon.NieuwePersoon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.*;

public class ControllerMain {

    public TextField prefix;
    public ImageButton search;
    public ImageButton add;
    public TableView<Person> tabel;
    public TableColumn<Person, String> familienaam;
    public TableColumn<Person, String> voornaam;
    public TableColumn<Person, ImageButton> edit;
    public TableColumn<Person, ImageButton> trash;

    private DataAccessProvider dap;
    private DataAccessContext dac;
    private PersonDAO personDAO;

    public ControllerMain(){
        dap = new JDBCDataAccessProvider();
        try {
            dac = dap.getDataAccessContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
        personDAO = dac.getPersonDAO();
    }

    public void initialize(){
        try {
            Image addImage = new Image(new FileInputStream(new File("src/Oefeningen/ContactsGUI/plus.png")));
            Image searchImage = new Image(new FileInputStream(new File("src/Oefeningen/ContactsGUI/search.png")));
            add.updateImages(addImage);
            search.updateImages(searchImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        voornaam.setCellValueFactory(new PropertyValueFactory<>("voornaam"));
        familienaam.setCellValueFactory(new PropertyValueFactory<>("familienaam"));
        trash.setCellFactory(column -> {
            ButtonCell<Person, ImageButton> cell = new ButtonCell<>("src/Oefeningen/ContactsGUI/trash.png");
            ImageButton imageButton = cell.getButton();
            imageButton.setOnAction(c ->{
                Person person = cell.getTableRow().getItem();
                try {
                    personDAO.deletePerson(person.getID());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    search();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return cell;
        });
        edit.setCellFactory(column -> {
            ButtonCell<Person, ImageButton> cell = new ButtonCell<>("src/Oefeningen/ContactsGUI/edit.png");
            ImageButton imageButton = cell.getButton();
            imageButton.setOnAction(c -> {
                ContactGegevens contactGegevens = new ContactGegevens();
                try {
                    Person person =  cell.getTableRow().getItem();
                    contactGegevens.start(new Stage(), person);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return cell;
        });

        try {
            search();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search() throws Exception {
        ObservableList<Person> model = FXCollections.observableArrayList();
        for(Person person : personDAO.getPersons(prefix.getText())){
            model.add(person);
        }
        tabel.setItems(model);
    }

    public void add() throws Exception {
        Stage stage = new Stage();
        new NieuwePersoon().start(stage, this);
    }
}
