package prog2.extra;

import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Set;

/**
 * Hoe men vroeger zou gedaan hebben wat nu in {@link Element} staat
 * en in {@link UsesElement}
 */
public class ElementOld {

    public static final int VUUR = 0;
    public static final int WATER = 1;
    public static final int LUCHT = 2;
    public static final int AARDE = 3;

    public static final Color[] KLEUREN = {
            Color.RED, Color.WHITE, Color.BLUE, Color.BLACK
    };

    public static final Set<Integer> EXTRA_MAGISCH = new HashSet<>();

    static {
        EXTRA_MAGISCH.add (VUUR);
        EXTRA_MAGISCH.add (LUCHT);
    }

    public static void main(String[] args) {
        int el = WATER;
        System.out.println("Kleur = " + KLEUREN[el]);
        System.out.println("Extra magisch? " + EXTRA_MAGISCH.contains(el));
    }


}
