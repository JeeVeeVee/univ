package prog2.threads;

import javafx.concurrent.Task;
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
public class ImageLoader8Companion {

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

    public void load() {
        progressPanel.setVisible(true);
        gridPane.setVisible(false);

        ImageLoaderTask task = new ImageLoaderTask();

        progressBar.progressProperty().bind(task.progressProperty());
        progressMessage.textProperty().bind(task.messageProperty());

        loadButton.disableProperty().bind(task.runningProperty());

        new Thread(task).start();
    }


    private static final String[] IMAGE_NAMES = {
            "aardbei", "ajuin", "ananas", "appel", "asperge", "banaan",
            "broccoli", "druiven", "framboos", "kiwi", "mais", "meloen", "peer",
            "peper", "perzik", "pickle", "pompelmoes", "tomaat", "watermeloen",
            "wortel"
    };

    /**
     * JavaFX-taak die prenten inleest. Geeft een array terug van alle prenten die zijn ingelezen.
     */
    public class ImageLoaderTask extends Task<Image[]> {

        @Override
        protected Image[] call() throws Exception {

            Image[] images = new Image[IMAGE_NAMES.length];
            updateProgress(0, images.length);

            for (int i = 0; i < images.length; i++) {
                try {
                    Thread.sleep(1000);  // voor demonstratiedoeleinden
                    images[i] = new Image("/prog2/memory/images/" + IMAGE_NAMES[i] + ".png");
                    updateProgress(i + 1, images.length);
                    updateMessage(IMAGE_NAMES[i]);
                } catch (InterruptedException ex) {
                    throw new RuntimeException("Onverwachte onderbreking", ex);
                }
            }

            return images;
        }

        @Override
        protected void succeeded() {
            int nrOfColumns = gridPane.getColumnConstraints().size();
            Image[] images = getValue();
            for (int i = 0; i < images.length; i++) {
                gridPane.add(new ImageView(images[i]), i % nrOfColumns, i / nrOfColumns);
            }
            progressPanel.setVisible(false);
            gridPane.setVisible(true);

        }

        @Override
        protected void failed() {
            progressBar.setVisible(false);
            updateMessage("Er ging iets fout :-(");
        }
    }
}
