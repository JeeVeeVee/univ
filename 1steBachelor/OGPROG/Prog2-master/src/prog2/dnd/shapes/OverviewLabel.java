package prog2.dnd.shapes;

import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class OverviewLabel extends AbstractShapeLabel {

    public OverviewLabel(double scale) {
        super(scale);
        setText("(leeg)");

        setOnDragOver(this::doDragOver);
        setOnDragDone(this::doDragDone);
    }

    private void doDragOver(DragEvent event) {
        if (event.getDragboard().hasContent(CUSTOM_DESCRIPTION) && event.getGestureSource() != this) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            event.consume();
        }
    }

    private void doDragDone(DragEvent event) {
        if (event.getTransferMode() == TransferMode.MOVE) {
            setText("(leeg)");
            setGraphic(null);
            this.description = null;
        }
    }
}
