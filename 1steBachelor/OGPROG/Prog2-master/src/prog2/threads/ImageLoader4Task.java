package prog2.threads;

import javafx.concurrent.Task;
import javafx.scene.image.Image;

/**
 * JavaFX-taak die prenten inleest. Geeft een array terug van alle prenten die zijn ingelezen.
 */
public class ImageLoader4Task extends Task<Image[]> {

    private static String[] IMAGE_NAMES = {
            "aardbei", "ajuin", "ananas", "appel", "asperge", "banaan",
            "broccoli", "druiven", "framboos", "kiwi", "mais", "meloen", "peer",
            "peper", "perzik", "pickle", "pompelmoes", "tomaat", "watermeloen",
            "wortel"
    };

    @Override
    protected Image[] call() throws Exception {

        Image[] images = new Image[IMAGE_NAMES.length];
        updateProgress(0, images.length);

        int i = 0;
        while (i < images.length && !isCancelled()) {
            try {
                Thread.sleep(1000);  // voor demonstratiedoeleinden
                images[i] = new Image("/prog2/memory/images/" + IMAGE_NAMES[i] + ".png");
                updateProgress(i+1, images.length);
                updateMessage(IMAGE_NAMES[i]);
                i++;
            } catch (InterruptedException ex) {
                // kan gevolg zijn van een 'cancel'
            }
        }

        return images;
    }
}
