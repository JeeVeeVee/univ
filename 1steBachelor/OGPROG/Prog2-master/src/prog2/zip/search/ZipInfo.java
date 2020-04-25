/* ZipInfo.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.zip.search;

/**
 * Bundelt de informatie over één gemeente.
 */
public class ZipInfo {

    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZipInfo(String zip, String name) {
        this.zip = zip;
        this.name = name;
    }

}
