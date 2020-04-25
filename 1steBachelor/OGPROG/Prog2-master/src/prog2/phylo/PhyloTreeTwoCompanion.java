/* PhyloTreeTwoCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.phylo;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;

/**
 * Partnerklasse voor {@code PhyloTreeTwo.fxml}.
 */
public class PhyloTreeTwoCompanion {

    public TreeView<NameURIPair> treeView;
    public Label label;

    public class SelectionListener implements InvalidationListener {

        @Override
        public void invalidated(Observable o) {
            TreeItem<NameURIPair> treeItem = treeView.getSelectionModel().getSelectedItem();
// of:            TreeItem<NameURIPair> treeItem = ((ObservableValue<TreeItem<NameURIPair>>)o).getValue();
            if (treeItem == null) {
                label.setGraphic(null);
                label.setText ("<leeg>");
            } else {
                NameURIPair nup = treeItem.getValue();
                if (nup.getUri() == null) {
                    label.setGraphic(null);
                    label.setText ("<geen foto>");
                } else {
                    label.setText (null);
                    label.setGraphic(new ImageView(nup.getUri()));
                }
            }
        }
    }

    public void initialize() {
        PhyloTreeReader ptr = new PhyloTreeReader();

        TreeItem<NameURIPair> treeItem = ptr.convertPhyloXML(
                ptr.readPhyloXML("/prog2/phylo/xml/phylo_example.xml"));
        treeView.setRoot(treeItem);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener(new SelectionListener());
    }
}
