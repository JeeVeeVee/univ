/* PhyloTreeReader.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.phylo;

import javafx.scene.control.TreeItem;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import prog2.phylo.xml.Clade;
import prog2.phylo.xml.Phylogeny;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Leest een PhyloXML-bestand in, en produceert een corresponderend
 * {@link TreeItem}. Dit gebeurt met een tussenstap via een lijst van {@link Phylogeny}-objecten.
 */
public class PhyloTreeReader {

    private Namespace namespace;

    PhyloTreeReader () {
        this.namespace = Namespace.getNamespace("http://www.phyloxml.org");
    }

    private Clade readClade(Element element) {
        // Kinderen zijn niet altijd aanwezigd
        Element uriElement = element.getChild("uri", namespace);
        String uri = null;
        if (uriElement != null) {
            uri = uriElement.getTextTrim();
        }

        Element nameElement = element.getChild("name", namespace);
        String name = null;
        if (nameElement != null) {
            name = nameElement.getTextNormalize();
        }

        return new Clade (
            element.getChildren("clade", namespace).stream()
                .map(this::readClade).collect(Collectors.toList()),
            name, uri
        );
    }

    public List<Phylogeny> readPhyloXML(String resource) {
        try {
            Document document = new SAXBuilder().build(PhyloTreeReader.class.getResource(resource));
            Element root = document.getRootElement();
            return root.getChildren("phylogeny", namespace).stream()
                    .map(el -> new Phylogeny(readClade(el.getChild("clade", namespace))))
                    .collect(Collectors.toList());
        } catch (JDOMException | IOException ex) {
            throw new RuntimeException("Could not read or find resource: " + resource, ex);
        }
    }

    private TreeItem<NameURIPair> convertClade(Clade clade) {
        TreeItem<NameURIPair> ti 
                = new TreeItem<>(new NameURIPair(clade.getName(),clade.getUri()));
        Iterable<Clade> list = clade.getCladeList();
        if (list != null) {
            for (Clade child : list) {
                ti.getChildren().add(convertClade(child));
            }
        }
        return ti;
    }

    private TreeItem<NameURIPair> convertPhylogeny(Phylogeny p) {
        TreeItem<NameURIPair> ti = convertClade(p.getClade());
        ti.setExpanded(true);
        return ti;
    }

    public TreeItem<NameURIPair> convertPhyloXML(List<Phylogeny> list) {
        TreeItem<NameURIPair> ti = new TreeItem<>();
        for (Phylogeny phylogeny : list) {
            ti.getChildren().add(convertPhylogeny(phylogeny));
        }
        return ti;
    }
}
