package prog2.combo;

import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Partnerklasse voor {@code Combo.fxml}
 */
public class ComboCompanion {

    public ComboBox<String> comboBox;

    public Circle circle;

    public void initialize() {


        comboBox.setOnAction(
                ev -> circle.setFill(Color.web(comboBox.getValue()))
        );

/*
        // Alternatief dat dichter bij MVC aanleunt
        comboBox.valueProperty().addListener(o -> circle.setFill(Color.web(comboBox.getValue())));
*/
    }

}
