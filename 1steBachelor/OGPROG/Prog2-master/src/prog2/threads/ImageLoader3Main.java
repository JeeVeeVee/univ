package prog2.threads;

import prog2.core.FXMLMain;

/**
 * Toont een aantal prenten die traag worden ingeladen.
 *
 * Voegt een voortgangsbalk (progress bar) toe aan {@link ImageLoader2Main}. Zorgt er ook voor
 * dat de 'inladen'-knop enkel actief is wanneer de achtergrondtaak niet aan het lopen is.
 */
public class ImageLoader3Main extends FXMLMain {

    public static void main(String[] args) {
        launch(args);
    }
}
