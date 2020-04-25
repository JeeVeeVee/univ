/* Copyright © 2016 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.inner;

import java.util.ArrayList;
import java.util.List;

/**
 * Voorbeeld van een klasse met een 'binnen'interface
 */
public class Vertaling {

    public interface Vertaler {
        String vertaal(String woord);
    }

    /**
     * Vertaal een lijst van woorden met behulp van een vertaler
     */
   public List<String> vertaalLijst (List<String> woordenLijst, Vertaler vertaler) {
	    List<String> resultaat = new ArrayList<>();
	    for (String str: woordenLijst) {
		    resultaat.add (vertaler.vertaal(str));
	    }
	    return resultaat;
    }

    /**
     * Deze methode kan een gegeven woord vertalen van een gegeven taal naar een andere
     * @param woord Woord dat moet vertaald worden
     * @param vanTaal Taal van het oorspronkelijk woord
     * @param naarTaal Taal waarnaar het moet vertaald worden
     */
    private String vertaalVanNaar (String woord, String vanTaal, String naarTaal) {
        // implementeer als oefening :-)
        return "TODO";
    }

    /**
     * Binnenklasse die kan vertalen van het Nederlands naar het Frans.
     */
    private class VertalerNlFr implements Vertaler {
        public String vertaal(String woord) {
            return vertaalVanNaar (woord, "NL", "FR");
        }
    }

     /**
      * Vertaal een lijst van woorden van het Nederlands naar het Frans. Versie 1: gebruikt
      * een (niet-statische) binnenklasse als vertaler.
      */
    public List<String> vertaalNlFr1 (List<String> woordenLijst) {
        return vertaalLijst (woordenLijst, new VertalerNlFr());
    }


     /**
      * Vertaal een lijst van woorden van het Nederlands naar het Frans. Versie 2: gebruikt
      * een anonieme binnenklasse als vertaler.
      */
    public List<String> vertaalNlFr2 (List<String> woordenLijst) {
        return vertaalLijst(woordenLijst, new Vertaler() {
            public String vertaal(String woord) {
                return vertaalVanNaar (woord, "NL", "FR");
            }
        });
    }

    // en nu met een 'lambda' (vanaf Java 8)
    public List<String> vertaalNlFr3 (List<String> woordenLijst) {
        return vertaalLijst(woordenLijst,
                woord -> vertaalVanNaar (woord, "NL", "FR")
        );
    }


}
