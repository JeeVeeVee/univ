/* NameURIPair.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.phylo;

import java.util.Objects;

/**
 * Klein object voor intern gebruik dat een naam en (eventueel) een uri bevat.
 *
 * <p> (Als oefening: ook nog een ge'cached'e Image?)
 */
public class NameURIPair {

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

    public void setUri(String uri) {
        this.uri = uri;
    }
    
    public NameURIPair(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public NameURIPair() {
        // must be filled in later by setters
    }

    @Override
    public String toString() {
        return Objects.requireNonNullElse(name, "(unnamed)"); // new since Java 9
    }
}
