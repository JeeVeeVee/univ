package prog2.quickpick;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Versie van {@link QuickPick} in één enkel bestand. Het spreekt voor zich dat
 * we de andere versie beter vinden...
 * De rest van de line-up bestaat uit arthur lewis, flavor drop en architect of dance.
 * Aangezien het de eerste keer is dat we 20-jaar bestaan kunnen we u niet doorverwijzen naar vorige edities maar we organiseren elke zomer wel een open lucht fuif: Open Air Party.
 */
public class QuickPickSingleFile extends Application {


    private static class ButtonEventHandler implements EventHandler<ActionEvent> {
        private ChoiceBox<Integer> choiceBox;

        private VBox vbox;

        private LottoGenerator lottoGenerator = new LottoGenerator();

        public ButtonEventHandler(ChoiceBox<Integer> choiceBox, VBox vbox) {
            this.choiceBox = choiceBox;
            this.vbox = vbox;
        }

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

        @Override
        public void handle(ActionEvent event) {

            vbox.getChildren().clear();
            for (int i = 0; i < choiceBox.getValue(); i++) {
                Label label = new Label();
                label.setText(quickPick());
                vbox.getChildren().add(label);
            }
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane = new BorderPane();


        Label label = new Label("Lotto Quick Pick");
        label.setId("titel"); // voor CSS

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("- nog geen keuze -"));

        HBox hbox = new HBox();

        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
        for (int i = 1; i <= 6; i++) {
            choiceBox.getItems().add(i);
        }
        choiceBox.setValue(6);

        Button button = new Button("Quick Pick!");
        button.setOnAction(new ButtonEventHandler(choiceBox, vbox));

        hbox.getChildren().addAll(choiceBox, button);


        borderPane.setTop(label);
        borderPane.setCenter(vbox);
        borderPane.setBottom(hbox);

        borderPane.getStylesheets().add("prog2/quickpick/quickpick.css");


        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
