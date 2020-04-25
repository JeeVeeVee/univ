/* PhyloTreeThreeCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.phylo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;

/**
 * Partnerklasse voor {@code PhyloTreeThree.fxml}.
 */
public class PhyloTreeThreeCompanion {

    public TreeView<NameURIPair> treeView;
    public Label label;

    public class SelectionListener implements ChangeListener<TreeItem<NameURIPair>> {

        @Override
        public void changed(ObservableValue<? extends TreeItem<NameURIPair>> ov, TreeItem<NameURIPair> oldValue, TreeItem<NameURIPair> newValue) {
            if (newValue == null) {
                label.setGraphic(null);
                label.setText ("<leeg>");
            } else {
                NameURIPair nup = newValue.getValue();
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
