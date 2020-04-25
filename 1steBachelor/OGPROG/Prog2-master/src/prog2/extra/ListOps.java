package prog2.extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Elementen verwijderen uit een lijst, zonder gebruik
 * van iterators.
 */
public class ListOps {

    /**
     * Genereer een lijst van willekeurige getallen en verwijder
     * daarna alle getallen die oneven zijn. Druk de lijst
     * af, deel daarna elk element van de lijst door 2, en
     * druk ze opnieuw af.
     *
     * Gebruikt removeIf en foreach - nieuw in Java 8
     */
    public static void main(String[] args) {

        Random RG = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(RG.nextInt(20));
        }

        list.removeIf(i -> i % 2 == 1);
        System.out.println("Enkel even getallen:");
        list.forEach(System.out::println);

        System.out.println("De helft van bovenstaande");
        list.replaceAll(i -> i /2);
        list.forEach(System.out::println);  // alternatief voor eerste forEach
    }

}
