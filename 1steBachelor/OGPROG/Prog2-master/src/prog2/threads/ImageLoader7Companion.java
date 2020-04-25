package prog2.threads;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Partnerklasse voor {@code ImageLoader3.fxml}
 */
public class ImageLoader7Companion {

    public ProgressBar progressBar;

    public Label progressMessage;

    public Node progressPanel;

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

    private ImageLoader3Task task;

    public void load() {
        progressPanel.setVisible(true);
        gridPane.setVisible(false);

        task = new ImageLoader3Task();
        task.setOnSucceeded(ev -> taskSucceeded());
        task.setOnFailed(ev -> taskFailed());

        progressBar.progressProperty().bind(task.progressProperty());
        progressMessage.textProperty().bind(task.messageProperty());

        loadButton.disableProperty().bind(task.runningProperty());

        new Thread(task).start();
    }

    private void taskSucceeded() {
        int nrOfColumns = gridPane.getColumnConstraints().size();
        Image[] images = task.getValue();
        for (int i = 0; i < images.length; i++) {
            gridPane.add(new ImageView(images[i]), i % nrOfColumns, i / nrOfColumns);
        }
        progressPanel.setVisible(false);
        gridPane.setVisible(true);
    }

    private void taskFailed() {
        progressBar.setVisible(false);
        progressMessage.textProperty().unbind();
        progressMessage.setText("Er ging iets fout :-(");
    }
}
