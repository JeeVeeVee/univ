package JavaFXComponenten.Tabellen.editeerbareTabel;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;

public class ResultCell extends TableCell<Student, Integer> implements EventHandler<MouseEvent> {
    private static final String CSS_CLASS_FAILED = "failed";

    public ResultCell(){
        setAlignment(Pos.BASELINE_CENTER);
    }

    protected void updateItem(Integer value, boolean empty){
        super.updateItem(value, empty);
        ObservableList<String> rowStyles = getTableRow().getStyleClass();
        rowStyles.removeAll(CSS_CLASS_FAILED);
        if(empty){
            setText(null);
        } else{
            setText(value.toString());
            if(value < 10){
                rowStyles.add(CSS_CLASS_FAILED);
            }
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
