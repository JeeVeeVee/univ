package prog2.threads;

import javafx.beans.Observable;
import javafx.concurrent.Worker;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Partnerklasse voor {@code ImageLoader4.fxml}
 */
public class ImageLoader4Companion {

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

    private ImageLoader4Task task;

    public void load() {
        progressPanel.setVisible(true);
        gridPane.setVisible(false);

        task = new ImageLoader4Task();
        task.stateProperty().addListener(this::taskStateChanged);

        progressBar.progressProperty().bind(task.progressProperty());
        progressMessage.textProperty().bind(task.messageProperty());

        loadButton.disableProperty().bind(task.runningProperty());

        new Thread(task).start();
    }

    public void cancelTask() {
        task.cancel(true);
    }

    private void taskStateChanged(Observable o) {
        if (task.getState() == Worker.State.SUCCEEDED) {
            // gelukt
            int nrOfColumns = gridPane.getColumnConstraints().size();
            Image[] images = task.getValue();
            for (int i = 0; i < images.length; i++) {
                gridPane.add(new ImageView(images[i]), i % nrOfColumns, i / nrOfColumns);
            }
            progressPanel.setVisible(false);
            gridPane.setVisible(true);

        } else if (task.getState() == Worker.State.FAILED) {
            // niet gelukt
            progressBar.setVisible(false);
            progressMessage.textProperty().unbind();
            progressMessage.setText("Er ging iets fout :-(");
        }
        // in de andere gevallen (READY, SCHEDULED, RUNNING, CANCELLED) hoeft er niets te gebeuren
    }
}
