package JavaFXComponenten.TreeView;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Controlla {
    public TreeView<NameURIPair> view;

    public void initialize(){
        PhyloTreeReader ptr = new PhyloTreeReader();
        TreeItem<NameURIPair> treeItem = ptr.convertPhyloXML(
                ptr.readPhyloXML("xml/phylo_example.xml"));
        view.setRoot(treeItem);
        view.setShowRoot(false);
    }

}
