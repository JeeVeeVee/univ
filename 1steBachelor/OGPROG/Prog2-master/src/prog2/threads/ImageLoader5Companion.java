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
 * Partnerklasse voor {@code ImageLoader5.fxml}
 */
public class ImageLoader5Companion {

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

    private ImageLoader5Task task;

    public void load() {
        progressPanel.setVisible(true);
        gridPane.setVisible(false);

        task = new ImageLoader5Task();
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
        if (task.getState() == Worker.State.SUCCEEDED || task.getState() == Worker.State.CANCELLED ) {
            // gelukt of geannuleerd
            int nrOfColumns = gridPane.getColumnConstraints().size();
            Image[] images = task.getImages(); // niet getValue!
            for (int i = 0; i < images.length; i++) {
                Image image = images[i];
                if (image != null) {
                    gridPane.add(new ImageView(image), i % nrOfColumns, i / nrOfColumns);
                }
            }
            progressPanel.setVisible(false);
            gridPane.setVisible(true);

        } else if (task.getState() == Worker.State.FAILED) {
            // niet gelukt
            progressBar.setVisible(false);
            progressMessage.textProperty().unbind();
            progressMessage.setText("Er ging iets fout :-(");
        }
        // in de andere gevallen (READY, SCHEDULED, RUNNING) hoeft er niets te gebeuren
    }
}
