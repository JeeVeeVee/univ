package prog2.threads;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * JavaFX-taak die prenten inleest. Toont de prenten één voor één in een
 * opgegeven grid pane.
 */
public class ImageLoader6Task extends Task<Void> {

    private static String[] IMAGE_NAMES = {
            "aardbei", "ajuin", "ananas", "appel", "asperge", "banaan",
            "broccoli", "druiven", "framboos", "kiwi", "mais", "meloen", "peer",
            "peper", "perzik", "pickle", "pompelmoes", "tomaat", "watermeloen",
            "wortel"
    };

    private GridPane gridPane;

    public ImageLoader6Task(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    @Override
    protected Void call() throws Exception {
        int nrOfColumns = gridPane.getColumnConstraints().size();

        for (int i = 0; i < IMAGE_NAMES.length; i++) {
            try {
                Thread.sleep(100);  // voor demonstratiedoeleinden
                Image image = new Image("/prog2/memory/images/" + IMAGE_NAMES[i] + ".png");
                int col = i % nrOfColumns;
                int row = i / nrOfColumns; // opgelet: deze variabelen zijn effectief nodig opdat de lambda zou compileren

                // onderstaande moet inderdaad in de JavaFX-draad worden uitgevoerd!
                Platform.runLater(
                        () -> gridPane.add(new ImageView(image), col, row)
                );
            } catch (InterruptedException ex) {
                throw new RuntimeException("Onverwachte onderbreking", ex);
            }
        }
        return null;
    }
}
