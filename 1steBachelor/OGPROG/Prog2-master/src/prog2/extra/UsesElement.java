/* UsesElement.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.extra;

import java.util.EnumMap;
import java.util.EnumSet;
import javafx.scene.paint.Color;

/**
 * Voorbeeld van verzamelingen van opsomtypes en maps met opsomtypes
 */
public final class UsesElement {
    
    public static final EnumMap<Element,Color> KLEUREN;
    
    static {
        KLEUREN = new EnumMap<>(Element.class);
        KLEUREN.put (Element.AARDE, Color.BLACK);
        KLEUREN.put (Element.LUCHT, Color.WHITE);
        KLEUREN.put (Element.WATER, Color.BLUE);
        KLEUREN.put (Element.VUUR, Color.RED);
    }
    
    public static final EnumSet<Element> EXTRA_MAGISCH;
    
    static {
        EXTRA_MAGISCH = EnumSet.noneOf (Element.class); // initieel lege verzameling
        EXTRA_MAGISCH.add(Element.VUUR);
        EXTRA_MAGISCH.add(Element.LUCHT);
    }
    
    public static void main(String[] args) {
        Element el = Element.VUUR;
        System.out.println("Kleur = " + KLEUREN.get (el));
        System.out.println("Extra magisch? " + EXTRA_MAGISCH.contains(el));
    }
    
}
