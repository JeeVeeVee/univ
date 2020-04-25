package prog2.combo;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Partnerklasse voor {@code ComboBis.fxml}
 */
public class ComboBisCompanion {

    public ComboBox<String> comboBox;

    public Circle circle;

    public static class ComboCell extends ListCell<String> {

        private Rectangle rectangle;

        public ComboCell() {
            this.rectangle = new Rectangle(10,10);
            setContentDisplay(ContentDisplay.LEFT);
        }

        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty); // Niet vergeten!
            if (empty) {
                setGraphic(null);
                setText(null);
                setStyle(null);
            } else {
                rectangle.setFill(Color.web(item));
                setGraphic(rectangle);
                setText(item);
                setStyle("-fx-base: " + item);
            }
        }
    }

    public void initialize() {
        comboBox.setOnAction(
                ev -> circle.setFill(Color.web(comboBox.getValue()))
        );

        comboBox.setCellFactory(list -> new ComboCell());
    }

}
