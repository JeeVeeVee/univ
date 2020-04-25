package prog2.threads;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Partnerklasse voor {@code ImageLoader0.fxml}
 */
public class ImageLoader0Companion {

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

    public void load() {
        placeHolder.setVisible(true);
        gridPane.setVisible(false);
        loadImages();
        placeHolder.setVisible(false);
        gridPane.setVisible(true);
    }

    private static final String[] IMAGE_NAMES = {
            "aardbei", "ajuin", "ananas", "appel", "asperge", "banaan",
            "broccoli", "druiven", "framboos", "kiwi", "mais", "meloen", "peer",
            "peper", "perzik", "pickle", "pompelmoes", "tomaat", "watermeloen",
            "wortel"
    };

    private void loadImages() {
        Image[] images = new Image[IMAGE_NAMES.length];

        for (int i = 0; i < images.length; i++) {
            try {
                Thread.sleep(1000);  // voor demonstratiedoeleinden
                images[i] = new Image("/prog2/memory/images/" + IMAGE_NAMES[i] + ".png");
            } catch (InterruptedException ex) {
                throw new RuntimeException("Onverwachte onderbreking", ex);
            }
        }

        int nrOfColumns = gridPane.getColumnConstraints().size();
        for (int i = 0; i < images.length; i++) {
            gridPane.add(new ImageView(images[i]), i % nrOfColumns, i / nrOfColumns);
        }

    }
}
