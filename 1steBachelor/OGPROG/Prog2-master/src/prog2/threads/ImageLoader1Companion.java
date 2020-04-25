package prog2.threads;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Partnerklasse voor {@code ImageLoader1.fxml}
 */
public class ImageLoader1Companion {

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


        new Thread(this::loadImages).start();

        // placeHolder.setVisible(false); // staat nu in imagesLoaded
        // gridPane.setVisible(true);
    }

    private static String[] IMAGE_NAMES = {
                    "aardbei", "ajuin", "ananas", "appel", "asperge", "banaan",
                    "broccoli", "druiven", "framboos", "kiwi", "mais", "meloen", "peer",
                    "peper", "perzik", "pickle", "pompelmoes", "tomaat", "watermeloen",
                    "wortel"
            };

    private Image[] images = new Image[IMAGE_NAMES.length];

    private void loadImages() {
        for (int i = 0; i < images.length; i++) {
            try {
                Thread.sleep(1000);  // voor demonstratiedoeleinden
                images[i] = new Image("/prog2/memory/images/" + IMAGE_NAMES[i] + ".png");
            } catch (InterruptedException ex) {
                throw new RuntimeException("Onverwachte onderbreking", ex);
            }
        }

        // onderstaande moet in de JavaFX-draad, anders wordt er een uitzondering opgegooid
        Platform.runLater(this::imagesLoaded);
    }

    private void imagesLoaded() {

        int nrOfColumns = gridPane.getColumnConstraints().size();
        for (int i = 0; i < images.length; i++) {
            gridPane.add(new ImageView(images[i]), i % nrOfColumns, i / nrOfColumns);
        }
        placeHolder.setVisible(false);
        gridPane.setVisible(true);
    }
}
