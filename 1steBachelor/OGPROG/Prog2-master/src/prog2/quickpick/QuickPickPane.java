package prog2.quickpick;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Paneel met de gebruikersinterface van {@link QuickPick}
 */
public class QuickPickPane extends BorderPane {

    private VBox vbox;

    private ChoiceBox<Integer> choiceBox;

    private LottoGenerator lottoGenerator = new LottoGenerator();

    private String quickPick() {
        int[] result = lottoGenerator.generateNumbers();
        StringBuilder b = new StringBuilder();
        b.append(result[0]);
        for (int i = 1; i < result.length; i++) {
            b.append(" - ");
            b.append(result[i]);
        }
        return b.toString();
    }

    public void handleButton (ActionEvent event) {
        vbox.getChildren().clear();
        for (int i=0; i < choiceBox.getValue(); i++) {
            Label label = new Label ();
            label.setText(quickPick());
            vbox.getChildren().add(label);
        }
    }

    public QuickPickPane () {
        Label label = new Label("Lotto Quick Pick");
        label.setId("titel"); // voor CSS

        HBox hbox = new HBox();
        Button button = new Button("Quick Pick!");
        button.setOnAction(this::handleButton);

        this.choiceBox = new ChoiceBox<>();
        for (int i = 1; i <= 6 ; i++) {
            choiceBox.getItems().add(i);
        }
        choiceBox.setValue(6);
        hbox.getChildren().addAll(choiceBox, button);

        this.vbox = new VBox();
        vbox.getChildren().add(new Label ("- nog geen keuze -"));

        setTop(label);
        setCenter(vbox);
        setBottom(hbox);

        getStylesheets().add("prog2/quickpick/quickpick.css");
    }
}
