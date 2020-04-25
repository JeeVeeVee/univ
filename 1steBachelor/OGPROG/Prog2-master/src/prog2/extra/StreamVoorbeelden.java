package prog2.extra;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Eenvoudige voorbeelden over het gebruik van streams.
 */
public class StreamVoorbeelden {

    private static void somVanKwadraten() {
        System.out.println("Som v eerste 10 kwadraten = " +
                IntStream.range(1, 11).map(i -> i * i).sum());
    }

    private static void kortsteWoorden() {
        List<String> woorden = List.of("een", "appel", "de", "peer", "banaan", "het" );
        woorden.stream().filter (w -> w.length() < 4).forEach(System.out::println);
    }

    public static final String[] NAMEN =
            { "nul", "één", "twee", "drie", "vier",
                    "vijf", "zes", "zeven", "acht", "negen"};

    private static void cijfers() {
        new Random().ints(20)
                .mapToObj(i -> NAMEN[Math.abs(i) % 10])
                .forEach(System.out::println);
    }

    private static void totaleLengte() {
        System.out.println(
                "Som van de lengtes van de woorden = " +
                Stream.of("appel", "peer", "banaan").mapToInt(String::length).sum()
        );
    }

    private static void concateneren() {
        System.out.println(
            Stream.of("appel", "peer", "banaan")
                    .reduce("", (x,y) -> x + "-" + y)
                    .substring(1)
        );
    }

    private static void concatenerenBis() {
        System.out.println(
            Stream.of("appel", "peer", "banaan")
                    .collect(Collectors.joining("-"))
        );
    }

    public static void main(String[] args) {
        somVanKwadraten();
        System.out.println();
        kortsteWoorden();
        System.out.println();
        cijfers();
        System.out.println();
        totaleLengte();
        System.out.println();
        concateneren();
        concatenerenBis();
    }

}
