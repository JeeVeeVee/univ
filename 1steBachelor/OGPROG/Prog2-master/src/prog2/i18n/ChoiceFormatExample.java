/* ChoiceFormatExample.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.i18n;

import java.text.MessageFormat;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Illustreert het gebruik van de 'choice'-optie bij {@link MessageFormat}.
 */
public class ChoiceFormatExample {
    
    private static final Random RG = new Random();
    
    public static void main(String[] args) {
        for (int i=0; i < 8; i++) {
            int value = RG.nextInt(4);
            String message = MessageFormat.format(
                    ResourceBundle.getBundle("prog2/i18n/i18n").getString("choice"),
                    value);
            System.out.println(message);
        }
    }
            
    
}
