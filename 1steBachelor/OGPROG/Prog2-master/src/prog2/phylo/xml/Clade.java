/* Clade.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.phylo.xml;

import java.util.List;

/**
 * Klasse die overeenkomt met het &lt;clade&gt-element in het XML-bestand.
 */
public class Clade {

    private List<Clade> cladeList;

    public List<Clade> getCladeList() {
        return cladeList;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String uri;

    public String getUri() {
        return uri;
    }

    public Clade(List<Clade> cladeList, String name, String uri) {
        this.cladeList = cladeList;
        this.name = name;
        this.uri = uri;
    }
}
