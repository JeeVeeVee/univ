/* Phylogeny.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package JavaFXComponenten.TreeView.xml;

/**
 ** Klasse die overeenkomt met het &lt;phylogeny&gt-element in het XML-bestand.
 */
public class Phylogeny {
    
    private Clade clade;

    public Clade getClade() {
        return clade;
    }

    public Phylogeny(Clade clade) {
        this.clade = clade;
    }
}
