package prog2.threads;

import javafx.concurrent.Task;
import javafx.scene.image.Image;

/**
 * JavaFX-taak die prenten inleest. Geeft een array terug van alle prenten die zijn ingelezen.
 */
public class ImageLoader2Task extends Task<Image[]> {

    private static String[] IMAGE_NAMES = {
            "aardbei", "ajuin", "ananas", "appel", "asperge", "banaan",
            "broccoli", "druiven", "framboos", "kiwi", "mais", "meloen", "peer",
            "peper", "perzik", "pickle", "pompelmoes", "tomaat", "watermeloen",
            "wortel"
    };

    @Override
    protected Image[] call() throws Exception {
        Image[] images = new Image[IMAGE_NAMES.length];

        for (int i = 0; i < images.length; i++) {
            try {
                Thread.sleep(100);  // voor demonstratiedoeleinden
                images[i] = new Image("/prog2/memory/images/" + IMAGE_NAMES[i] + ".png");
            } catch (InterruptedException ex) {
                throw new RuntimeException("Onverwachte onderbreking", ex);
            }
        }

        return images;
    }
}
