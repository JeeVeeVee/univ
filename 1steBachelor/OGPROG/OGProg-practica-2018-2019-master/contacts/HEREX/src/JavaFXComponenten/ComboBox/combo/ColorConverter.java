package JavaFXComponenten.ComboBox.combo;

import javafx.scene.paint.Color;
import javafx.util.StringConverter;

/**
 * Zet kleuren om naar strings en omgekeerd.
 */
public class ColorConverter extends StringConverter<Color> {
    @Override
    public String toString(Color color) {
        // zie broncode van Color.toString
        if (color == null) {
            return null;
        } else {
            String name = WebColorNames.toName(color);
            if (name == null) {
                return String.format("#%02x%02x%02x",
                        (int) Math.round(color.getRed() * 255.0),
                        (int) Math.round(color.getGreen() * 255.0),
                        (int) Math.round(color.getBlue() * 255.0)
                );
            } else {
                return name;
            }
        }
    }

    @Override
    public Color fromString(String string) {
        if (string == null) {
            return null;
        } else {
            return Color.web(string);
        }
    }
}