package JavaFXComponenten.Tabellen.eenvoudigeTabel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controlla {
    public TableView<ZipInfo> tabel;
    public TextField prefix;
    public TableColumn<ZipInfo, String> zip;
    public TableColumn<ZipInfo, String> name;

    private ZipSearcher zipSearcher;

    public Controlla(){
        this.zipSearcher = new ZipSearcher();
    }

    public void initialize(){
        zip.setCellValueFactory(new PropertyValueFactory<>("zip"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    public void doSearch(){
        ObservableList<ZipInfo> model = FXCollections.observableArrayList();
        for(ZipInfo zipInfo : zipSearcher.find(prefix.getText())){
            model.add(zipInfo);
        }
        tabel.setItems(model);
    }
}
