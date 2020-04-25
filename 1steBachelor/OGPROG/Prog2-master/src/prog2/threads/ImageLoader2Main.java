package prog2.threads;

import prog2.core.FXMLMain;

/**
 * Toont een aantal prenten die traag worden ingeladen.
 *
 * Doet hetzelfde als {@link ImageLoader1Main} maar gebruikt een JavaFX-task in plaats
 * van een Runnable.
 */
public class ImageLoader2Main extends FXMLMain {

    public static void main(String[] args) {
        launch(args);
    }
}
