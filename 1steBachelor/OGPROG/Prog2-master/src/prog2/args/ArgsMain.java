package prog2.args;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

/**
 * Dit programma demonstreert het gebruik van opdrachtlijnparameters en hoe die
 * worden doorgegeven aan JavaFX. Toont ook het gebruik van 'init'.
 */
public class ArgsMain extends Application {

    private int height; // hoogte van de rechthoek

    private int width; // breedte van de rechthoek

    private Color color = Color.BLUE; // kleur van de rechthoek

    /**
     * Toont een foutbericht en stopt het programma
     */
    private static void error(String bericht) {
        System.err.println("*ERROR* -- " + bericht);
        Platform.exit(); // Opgelet! Platform.exit() is ook nodig als 'launch' niet wordt opgeroepen!
    }

    @Override
    public void init() {

        List<String> argList = getParameters().getRaw();
        try {

            width = Integer.parseInt(argList.get(0));
            height = Integer.parseInt(argList.get(1));
            if (argList.size() == 3) {
                color = Color.web(argList.get(2));
            }

        } catch (NumberFormatException ex) {
            error("De eerste twee parameters moeten numeriek zijn");
        } catch (IllegalArgumentException ex) {
            error("Derde parameter moet een kleur voorstellen");
        }

        if (height < 0 || width < 0) {
            error("Breedte en hoogte moeten positief zijn");
        }

    }


    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setFill(color);
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10);
        BorderPane pane = new BorderPane();
        pane.setCenter(rectangle);
        stage.setScene(new Scene(pane, width + 40, height + 40));
        stage.setTitle("Uw rechthoek");
        stage.show();
    }

    /**
     * Het programma kan worden opgeroepen met twee of drie parameters. De eerste
     * twee geven de breedte en hoogte van de rechthoek. De laatste (optioneel) het kleur.
     * Default kleur is blauw.\
     */
    public static void main(String[] args) {

        // onderstaande kan ook in init
        if (args.length < 2 || args.length > 3) {
            error("Het programma moet twee of drie parameters hebben");
        } else {
            launch(args);
        }
    }
}
