/* PhyloTreeThreeMain.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.phylo;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import prog2.core.FXMLMain;

/**
 * Zelfde als {@link PhyloTreeTwoMain}, maar gebruikt een {@link ChangeListener} 
 * in plaats van een {@link InvalidationListener} om de selectie te volgen.
 */
public class PhyloTreeThreeMain extends FXMLMain {

    public static void main(String[] args) {
        launch(args);
    }
}
