package prog2.tracker.table;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

/**
 * Table cell waarop je kan dubbelklikken, bedoeld om in een table cell factory gebruikt te
 * worden. Je moet bij het aanmaken een actiegebeurtenisverwerker registeren die op dit dubbelklikken reageert.
 */
public class DoubleClickableTableCell<S, T> extends TextFieldTableCell<S, T>
        implements EventHandler<MouseEvent> {

    private EventHandler<ActionEvent> actionEventHandler;

    public DoubleClickableTableCell(EventHandler<ActionEvent> actionEventHandler) {
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

    public DoubleClickableTableCell(EventHandler<ActionEvent> actionEventHandler, StringConverter<T> converter) {
        super (converter);
        this.actionEventHandler = actionEventHandler;
        setOnMouseClicked(this);
    }

}
