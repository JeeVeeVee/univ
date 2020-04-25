package JavaFXComponenten.Tabellen.editeerbareTabel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class Controlla {

    public TableView<Student> tabel;
    public TableColumn<Student, String> fam;
    public TableColumn<Student, String> naam;
    public TableColumn<Student, Integer> result;
    public TextField coursenr;

    private DataProvider dataProvider;

    public Controlla(){
        dataProvider = new DataProvider();
    }

    public void initialize(){
        fam.setCellValueFactory(new PropertyValueFactory<>("achternaam"));
        naam.setCellValueFactory(new PropertyValueFactory<>("voornaam"));
        result.setCellValueFactory(new PropertyValueFactory<>("score"));
        tabel.setEditable(true);
        fam.setEditable(false);
        naam.setEditable(false);
        result.setEditable(true);
        result.setCellFactory(column -> new TextFieldTableCell<>(new IntegerStringConverter()));
    }

    public void update(){
        ObservableList<Student> model = FXCollections.observableArrayList();
        for (Student student : dataProvider.getStudents(Integer.parseInt(coursenr.getText()))){
            model.add(student);
            System.out.println(student.toString());
        }
        tabel.setItems(model);
    }


}
