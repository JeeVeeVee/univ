package prog2.dnd.shapes;

import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;

public class ShapeLabel extends AbstractShapeLabel {

    public ShapeLabel(double scale) {
        super(scale);
        this.description = new ShapeDescription(ShapeType.SQUARE, Color.PINK, 1.0);
        setShape(description);

        setOnDragOver(this::doDragOver);
    }

    private void doDragOver(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (event.getGestureSource() != this) {
            if (db.hasContent(CommandLabel.CUSTOM_COMMAND) ||
                    db.hasContent(CUSTOM_DESCRIPTION)) {
                event.acceptTransferModes(TransferMode.COPY);
                event.consume();
            }
        }
    }

}
