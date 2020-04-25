/* PhyloTreeOneCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.phylo;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * Partnerklasse voor {@code PhyloTreeOne.xml}.
 */
public class PhyloTreeOneCompanion {

    public TreeView<NameURIPair> treeView;

    public void initialize() {
        // Alternatief 1
/*
        PhyloTreeReader ptr = new PhyloTreeReader();
        TreeItem<NameURIPair> treeItem = ptr.convertPhyloXML(
                ptr.readPhyloXML("/prog2/phylo/xml/phylo_example.xml"));
*/

        // Alternatief 2
        PhyloTreeReaderBis ptr2 = new PhyloTreeReaderBis();
        TreeItem<NameURIPair> treeItem = ptr2.readPhyloXML("/prog2/phylo/xml/phylo_example.xml");

        treeView.setRoot(treeItem);
        treeView.setShowRoot(false);
    }
}
