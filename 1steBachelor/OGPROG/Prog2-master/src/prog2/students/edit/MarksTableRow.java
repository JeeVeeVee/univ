package prog2.students.edit;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.control.TableRow;

/**
 * Past de stijlklassen van de rijen aan al naargelang hun inhoud.
 */
public class MarksTableRow extends TableRow<Row> implements InvalidationListener {

    private Row lastRow;

    @Override
    protected void updateItem(Row row, boolean empty) {
        super.updateItem(row, empty);

        // luister naar de nieuwe rij
        if (lastRow != row) {
            if (lastRow != null) {
                lastRow.changedProperty().removeListener(this);
                lastRow.marksProperty().removeListener(this);
            }
            if (empty) {
                lastRow = null;
            } else {
                lastRow = row;
                row.changedProperty().addListener(this);
                row.marksProperty().addListener(this);
            }
            updateStyles();
        }
    }

    private void updateStyles() {
        ObservableList<String> rowStyles = getStyleClass();

        rowStyles.removeAll(CSS_CLASS_CHANGED, CSS_CLASS_FAILED);

        if (lastRow != null) {
            if (lastRow.isChanged()) {
                rowStyles.add(CSS_CLASS_CHANGED);
            }
            if (lastRow.getMarks() < 10) {
                rowStyles.add(CSS_CLASS_FAILED);
            }
        }
    }

    private static final String CSS_CLASS_CHANGED = "changed";

    private static final String CSS_CLASS_FAILED = "failed";


    @Override
    public void invalidated(Observable o) {
        updateStyles();
    }

}
