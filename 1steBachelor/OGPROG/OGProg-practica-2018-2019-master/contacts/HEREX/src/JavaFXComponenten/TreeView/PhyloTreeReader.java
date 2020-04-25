package JavaFXComponenten.TreeView;

import JavaFXComponenten.TreeView.xml.Clade;
import JavaFXComponenten.TreeView.xml.Phylogeny;
import javafx.scene.control.TreeItem;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PhyloTreeReader {
    private Namespace namespace;


    PhyloTreeReader(){
        this.namespace = Namespace.getNamespace("http://www.phyloxml.org");
    }

    private Clade readClade(Element element){
        Element urielement = element.getChild("uri", namespace);
        String uri = null;
        if (urielement != null){
            uri = urielement.getTextTrim();
        }
        Element nameElement = element.getChild("name", namespace);
        String name = null;
        if (nameElement != null){
            name = nameElement.getTextNormalize();
        }
        return new Clade (
                element.getChildren("clade", namespace).stream()
                        .map(this::readClade).collect(Collectors.toList()),
                name, uri
        );
    }

    public List<Phylogeny> readPhyloXML(String recource){
        try {
            Document document = new SAXBuilder().build(PhyloTreeReader.class.getResource(recource));
            Element root = document.getRootElement();
            return root.getChildren("phylogeny", namespace).stream()
                    .map(el -> new Phylogeny(readClade(el.getChild("clade", namespace))))
                    .collect(Collectors.toList());
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private TreeItem<NameURIPair> convertClade(Clade clade){
        TreeItem<NameURIPair> ti
                = new TreeItem<>(new NameURIPair(clade.getName(), clade.getUri()));
        Iterable<Clade> list = clade.getCladeList();
        if (list != null){
            for(Clade child : list){
                ti.getChildren().add(convertClade(child));
            }
        }
        return ti;
    }

    private TreeItem<NameURIPair> convertPhylogeny(Phylogeny phylogeny) {
        TreeItem<NameURIPair> ti = convertClade(phylogeny.getClade());
        ti.setExpanded(true);
        return ti;
    }

    public TreeItem<NameURIPair> convertPhyloXML(List<Phylogeny> list){
        TreeItem<NameURIPair> ti = new TreeItem<>();
        for(Phylogeny phylogeny : list){
            ti.getChildren().add(convertPhylogeny(phylogeny));
        }
        return ti;
    }
}
