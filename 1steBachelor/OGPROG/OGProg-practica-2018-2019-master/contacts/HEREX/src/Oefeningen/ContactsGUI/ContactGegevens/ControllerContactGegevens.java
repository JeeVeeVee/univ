package Oefeningen.ContactsGUI.ContactGegevens;

import Oefeningen.ContactsGUI.ButtonCell;
import Oefeningen.ContactsGUI.DatabankAccess.*;
import Oefeningen.ContactsGUI.DatabankAccess.jdbc.JDBCDataAccessProvider;
import Oefeningen.ContactsGUI.ImageButton;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ControllerContactGegevens {

    public TextField voornaam;
    public TextField familienaam;
    public TableView<Contact> tabel;
    public TableColumn<Contact, String> type;
    public TableColumn<Contact, String> adress;
    public TableColumn<Contact, ImageButton> trash;
    public ImageButton save;
    public ImageButton add;
    public ChoiceBox select;

    private Person person;
    private DataAccessProvider dap;
    private DataAccessContext dac;

    public ControllerContactGegevens(Person person){
        this.person = person;
        this.dap = new JDBCDataAccessProvider();
        try {
            this.dac = dap.getDataAccessContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        ContactDAO contactDAO= dac.getContactDAO();
        //Vult TextFields met naam
        voornaam.setText(person.getVoornaam());
        familienaam.setText(person.getFamilienaam());

        //in order maken van de tabel

        tabel.setEditable(true);
        type.setEditable(false);
        adress.setCellFactory(c -> {
            return new TextFieldTableCell<>(new StringConverter<String>() {
                @Override
                public String toString(String s) {
                    return s;
                }

                @Override
                public String fromString(String s) {
                    return s;
                }
            });
        });
        adress.setOnEditCommit(t -> {
            Contact contact = t.getRowValue();
            try {
                contactDAO.updateContact(contact.getId(), t.getNewValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
            update();
        });
        type.setCellValueFactory(row -> new SimpleStringProperty(row.getValue().getTypeString()));
        adress.setCellValueFactory(new PropertyValueFactory<>("address"));
        try {
            Image saveImage = new Image(new FileInputStream(new File("src/Oefeningen/ContactsGUI/save.png")));
            Image addImage = new Image(new FileInputStream(new File("src/Oefeningen/ContactsGUI/plus.png")));
            save.updateImages(saveImage);
            add.updateImages(addImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        trash.setCellFactory(column -> {
            ButtonCell<Contact, ImageButton> cell = new ButtonCell<>("src/Oefeningen/ContactsGUI/trash.png");
            ImageButton imageButton = cell.getButton();
            imageButton.setOnAction(c ->{
                 Contact contact= cell.getTableRow().getItem();
                try {
                    contactDAO.deleteContact(contact.getId());
                    update();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            return cell;
        });
        update();

        //fix combobox
        ObservableList<String> types = FXCollections.observableArrayList(
                "E-mail", "Fax", "Mobiele Telefoon", "Vaste Telefoon"
        );
        select.setItems(types);
    }

    public void update(){
        ContactDAO contactDAO = dac.getContactDAO();
        ObservableList<Contact> model = FXCollections.observableArrayList();
        try {
            for(Contact contact : contactDAO.findContacts(person.getID())) {
                model.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabel.setItems(model);
    }



    public void add(){
        if (select.getValue() !=  null){
            ContactDAO contactDAO = dac.getContactDAO();
            try {
                contactDAO.createContact(person.getID(), select.getValue().toString().charAt(0), "vul in ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        update();
    }

    public void save(){
        PersonDAO personDAO = dac.getPersonDAO();
        try {
            personDAO.updatePerson(person.getID(), familienaam.getText(), voornaam.getText());
            cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cancel(){
        Stage stage = (Stage) voornaam.getScene().getWindow();
        stage.close();
    }
}
