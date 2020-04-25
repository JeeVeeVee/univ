/* AboutThreeComponent.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.config;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * Breidt {@link CloseButtonComponent} uit door 'About'-gegevens te plaatsen
 * in het bovenste deel van het venster. Dit gedeelte wordt zelf ook nog ingeladen
 * met de FXMLLoader
 */
public class AboutThreeComponent extends CloseButtonComponent {

    public AboutThreeComponent(Stage stage) throws IOException {
        super(stage);

        // Alternatief 1. Vervang de bestaande lege HBox door een andere
        replaceHBox(FXMLLoader.load(
                getClass().getResource("AboutThreePart.fxml")
        ));

        // Alternatief 2. Vervang de inhoud van de HBox door één enkele component
        // (hier opnieuw een HBox)
//        setContents((Node) FXMLLoader.load(
//                getClass().getResource("AboutThreePart.fxml")
//        ));

        // Alternatief 3. Voeg afzonderlijke onderdelen toe aan de HBox
        // (hier twee labels)
//        addToContents(new Label("Een"), new Label("Twee"));

    }

}
