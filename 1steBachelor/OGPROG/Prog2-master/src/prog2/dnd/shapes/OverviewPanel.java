package prog2.dnd.shapes;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class OverviewPanel extends GridPane {

    public OverviewPanel () {

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                add(new OverviewLabel(1.5), i, j);
            }
        }
    }


}
