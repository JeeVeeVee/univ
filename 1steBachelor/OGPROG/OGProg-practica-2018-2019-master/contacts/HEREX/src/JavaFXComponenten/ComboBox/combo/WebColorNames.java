package JavaFXComponenten.ComboBox.combo;

import javafx.scene.paint.Color;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasse die toelaat om aan de hand van een kleur uit te zoeken wat de naam is van deze kleur.
 * In essentie komt het er gewoon op neer deze kleur op te zoeken in een map, De manier waarop die map
 * wordt ingevuld is echter nogal bijzonder...
 */
public class WebColorNames {

    private static final Map<Color,String> NAMES = initMap ();

    public static String toName (Color color) {
        return NAMES.get(color);
    }

    public static Map<Color,String> initMap () {
        Map<Color,String> map = new HashMap<>();
        for (Field field : Color.class.getFields()) {
            int modifiers = field.getModifiers();
            if (Modifier.isFinal(modifiers) &&
                    Modifier.isStatic(modifiers) &&
                    Modifier.isPublic(modifiers) &&
                    field.getType() == Color.class) {
                try {
                    map.put ((Color)field.get(null), field.getName().toLowerCase());
                } catch (IllegalAccessException e) {
                    //  negeer velden zonder waarde - komt in principe niet voor
                }
            }
        }
        return map;
    }

}
