package prog2.threads;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Partnerklasse voor {@code ImageLoader6.fxml}
 */
public class ImageLoader6Companion {

    public GridPane gridPane;

    public Label label;

    public Button loadButton;

    private static final Random RG = new Random();

    public void initialize() {
        newRandom();
    }

    public void newRandom() {
        label.setText(Integer.toString(RG.nextInt(Integer.MAX_VALUE)));
    }

    public void load() {
        ImageLoader6Task task = new ImageLoader6Task(gridPane);
        new Thread(task).start();
        loadButton.disableProperty().bind(task.runningProperty());
    }
}
