package prog2.tracker.table;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;
import javafx.scene.input.MouseEvent;

/**
 * Table row waarop je kan dubbelklikken, bedoeld om in een table row cell factory gebruikt te
 * worden.
 */
public class DoubleClickableTableRow<S> extends TableRow<S> implements EventHandler<MouseEvent> {

    private EventHandler<ActionEvent> actionEventHandler;

    public DoubleClickableTableRow(EventHandler<ActionEvent> actionEventHandler) {
        this.actionEventHandler = actionEventHandler;
        setOnMouseClicked(this);
    }

    @Override
    public void handle(MouseEvent t) {
        if (t.getClickCount() > 1) {
            ActionEvent ae = new ActionEvent(this, null);
            actionEventHandler.handle(ae);
        }
    }
}
