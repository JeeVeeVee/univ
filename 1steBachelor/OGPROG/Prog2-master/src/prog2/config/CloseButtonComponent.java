/* CloseButtonComponent.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 *//* CloseButtonComponent.java
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
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Component die als inhoudspaneel kan dienen van een venster. Bevat een
 * blanko {@link HBox} bovenaan en onderaan een knop waarmee het venster
 * gesloten wordt.
 */
public class CloseButtonComponent extends VBox {

    private CloseButtonCompanion companion;
    
    /**
     * Maak een component aan van dit type met een knop die het opgegeven venster
     * sluit.
     * @param stage Venster dat gesloten wordt bij het klikken op de knop. Wellicht
     * het venster waarin deze component zich bevindt.
     * @throws IOException 
     */
    public CloseButtonComponent (Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader (
                AboutThreeMain.class.getResource("CloseButtonComponent.fxml")
                );
        loader.setRoot(this);
        loader.load();
        this.companion = loader.getController();
        companion.setStage(stage);
        
    }
    

    /**
     * Eerste optie. Vervang de bestaande {@link HBox} door de opgegeven component
     * @param component vervangt de bestaande HBox 
     */
    protected void replaceHBox (HBox component) {
        getChildren().set(0, component);
    }

    /**
     * Tweede optie, Vul de bestaande blanko {@link HBox} op met de opgegeven inhoud
     */
    protected void setContents (Node... contents) {
        companion.setContents (contents);
    }

    /**
     * Derde optie. Voeg de gegeven componenten toe als kind aan de bestaande
     * {@link HBox}.
     * @param components kinderen die moeten toegevoegd worden
     */
    protected void addToContents (Node... components) {
        companion.addToContents(components);
    }
}
