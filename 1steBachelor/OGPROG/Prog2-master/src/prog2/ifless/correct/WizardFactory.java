/* WizardFactory.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.ifless.correct;

/**
 *
 */
public class WizardFactory implements PlayerFactory {

    @Override
    public Player createPlayer() {
        return  new Wizard();
    }

}
