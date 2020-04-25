package prog2.dnd.shapes;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class ColorCommand implements Command, Serializable {
    private static final long serialVersionUID = -3814156145397939477L;

    // Onderstaande werkt niet omdat de klasse Color niet serialiseerbaar is
    //private Color color;

    // Dus gebruiken we in de plaats de drie  RGB-componenten
    private double red;
    private double green;
    private double blue;

    public ColorCommand(Color color) {
        setColor(color);
    }

    public Color getColor() {
        return Color.color(red, green, blue);
    }

    public void setColor(Color color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
    }

    @Override
    public void updateDescription(ShapeDescription description) {
        description.setColor(getColor());
    }
}
