package prog2.phylo;

import javafx.scene.control.TreeItem;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Zelfde functionaliteit als {@link PhyloTreeReader} maar op een andere manier
 * geïmplementeerd.
 * <ul>
 * <li>De {@link TreeItem}s worden rechtstreeks aangemaakt zonder eerst
 * een lijst van {@link prog2.phylo.xml.Phylogeny}-objecten aan te maken.</li>
 * <li>We gebruiken de methode {@link Element@getChildren} zonder parameter. Dit
 * laat ons o.a. toe om het gebruik van een 'name space' te omzeilen.</li>
 * </ul>
 */
public class PhyloTreeReaderBis {

    public TreeItem<NameURIPair> convertClade(Element parent) {
        NameURIPair pair = new NameURIPair();
        TreeItem<NameURIPair> ti = new TreeItem<>(pair);
        for (Element element : parent.getChildren()) {
            switch(element.getName()) {
                case "name":
                    pair.setName(element.getTextNormalize());
                    break;
                case "uri":
                    pair.setUri(element.getTextTrim());
                    break;
                case "clade":
                    ti.getChildren().add(convertClade(element));
                    break;
                default: // bijvoorbeeld branch_length
                    // negeer
                    break;
            }
        }
        return ti;
    }

    public TreeItem<NameURIPair> convertPhylogeny(Element element) {
        // we weten dat dit element precies één kind, namelijk een clade
        return convertClade(element.getChildren().get(0));
    }

    public TreeItem<NameURIPair> readPhyloXML(String resource) {
        try {
            Document document = new SAXBuilder().build(PhyloTreeReader.class.getResource(resource));
            Element root = document.getRootElement();
            TreeItem<NameURIPair> ti = new TreeItem<>();
            ti.getChildren().addAll(
                    root.getChildren().stream()
                            .map(this::convertPhylogeny)
                            .collect(Collectors.toList())
            );
            return ti;
        } catch (JDOMException | IOException ex) {
            throw new RuntimeException("Could not read or find resource: " + resource, ex);
        }
    }

}
