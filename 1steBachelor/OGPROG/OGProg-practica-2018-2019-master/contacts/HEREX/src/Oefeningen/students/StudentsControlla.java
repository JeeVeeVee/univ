package Oefeningen.students;

import Oefeningen.students.databank.DataAccessContext;
import Oefeningen.students.databank.DataAccessProvider;
import Oefeningen.students.databank.MarksInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class StudentsControlla {

    public TableView<MarksInfo> tabel;
    public TableColumn<MarksInfo, String> voornaam;
    public TableColumn<MarksInfo, String> achternaam;
    public TableColumn<MarksInfo, Integer> score;

    public TextField cursusnr;
    public Label cursusnaam;

    private DataAccessProvider dap;
    private DataAccessContext dac;

    public StudentsControlla() throws SQLException {
        this.dap = new DataAccessProvider();
        this.dac = dap.getDataAccessContext();
    }

    public void initialize(){
        voornaam.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        achternaam.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        score.setCellValueFactory(new PropertyValueFactory<>("marks"));
    }

    public void zoek() throws SQLException {
        Iterable<MarksInfo> data = dac.getMarkInfoDAO().listMarks(Integer.parseInt(cursusnr.getText()));
        ObservableList<MarksInfo> model = FXCollections.observableArrayList();
        for(MarksInfo marksInfo : data){
            model.add(marksInfo);
        }
        tabel.setItems(model);
    }
}
