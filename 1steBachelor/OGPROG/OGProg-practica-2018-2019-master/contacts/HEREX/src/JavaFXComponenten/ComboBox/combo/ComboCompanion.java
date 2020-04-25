package JavaFXComponenten.ComboBox.combo;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;

public class ComboCompanion {

    private static final StringConverter<Color> CONVERTER = new ColorConverter();

    public ComboBox<Color> comboBox;

    public Circle circle;

    public static class ComboCell extends ListCell<Color> {

        private Rectangle rectangle;

        public ComboCell(ListView<Color> list) {
            this.rectangle = new Rectangle(10,10);
            setContentDisplay(ContentDisplay.LEFT);
        }

        protected void updateItem(Color item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                rectangle.setFill(item);
                setGraphic(rectangle);
                String itemString = CONVERTER.toString(item);
                setText(itemString);
                setStyle("-fx-base: " + item);
            }
        }
    }

    public void initialize() {
        comboBox.setConverter(CONVERTER); // kan ook in FXML
        comboBox.setOnAction(
                ev -> circle.setFill(comboBox.getValue())
        );

        comboBox.setCellFactory(ComboCell::new);
    }

}