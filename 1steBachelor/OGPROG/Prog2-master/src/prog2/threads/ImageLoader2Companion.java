package prog2.threads;

import javafx.beans.Observable;
import javafx.concurrent.Worker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Partnerklasse voor {@code ImageLoader2.fxml}
 */
public class ImageLoader2Companion {

    public Label placeHolder;

    public GridPane gridPane;

    public Label label;

    private static final Random RG = new Random();

    public void initialize() {
        newRandom();
    }

    public void newRandom() {
        label.setText(Integer.toString(RG.nextInt(Integer.MAX_VALUE)));
    }

    private ImageLoader2Task task;

    public void load() {
        placeHolder.setVisible(true);
        gridPane.setVisible(false);

        task = new ImageLoader2Task();
        task.stateProperty().addListener(this::taskStateChanged);
        // alternatief: doe deze klasse InvalidationListener implementeren
        new Thread(task).start();
    }

    private void taskStateChanged(Observable o) {
        if (task.getState() == Worker.State.SUCCEEDED) {
            // gelukt
            int nrOfColumns = gridPane.getColumnConstraints().size();
            Image[] images = task.getValue();
            for (int i = 0; i < images.length; i++) {
                gridPane.add(new ImageView(images[i]), i % nrOfColumns, i / nrOfColumns);
            }
            placeHolder.setVisible(false);
            gridPane.setVisible(true);
        } else if (task.getState() == Worker.State.FAILED) {
            // niet gelukt
            placeHolder.setText("Er ging iets fout :-(");
        }
        // in de andere gevallen (READY, SCHEDULED, RUNNING, CANCELLED) hoeft er niets te gebeuren
    }
}
