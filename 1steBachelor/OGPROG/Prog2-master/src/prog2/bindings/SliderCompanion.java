package prog2.bindings;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

/**
 * Partnerklasse voor {@code SlidersOne.fxml}
 */
public class SliderCompanion {

    public Slider slider;
    public TextField field;

    public void initialize() {

        field.textProperty().bindBidirectional(slider.valueProperty(),
                new NumberStringConverter()
        );

    }

}
