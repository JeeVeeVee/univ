package vieroprij;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Provides the discs that are used in the game.
 */
public class DiscFactory {

    // The current disc shown in the game, or null if none.
    private Circle disc;

    /**
     * @return the existing disc, which is reused,
     * until a new move is finally played.
     */
    public Circle getDisc() {
        return disc;
    }

    /**
     * Create a new disc of the designated color.
     */
    public Circle Disc(Color color) {
        // Create a disc which can be played.
        disc = new Circle(Config.getDiskRadius());
        disc.setFill(color);
        disc.setOpacity(.9);

        // Add a bit of 3D-ish effect
        InnerShadow shadow = new InnerShadow();
        shadow.setOffsetX(1.0f);
        shadow.setOffsetY(1.0f);
        disc.setEffect(shadow);
        disc.setCache(true);

        // Set center alignment.
        GridPane.setHalignment(disc, HPos.CENTER);
        GridPane.setValignment(disc, VPos.CENTER);
        return disc;
    }

    /**
     * Destructively remove the current disc disc
     * when it is going to be used to complete a new move.
     * @return the disc
     */
    public Circle takeDisc() {
        Circle oldDisc = disc;
        disc = null;
        return oldDisc;
    }

}
