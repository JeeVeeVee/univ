package prog2.extra;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Nog meer voorbeelden van het gebruik van streams.
 * <p>
 * Opgelet: leest van een bestand in het file system, zorg
 * dat de current directory de juiste is!
 */
public class Goederen {

    private static void allesAfdrukken() throws IOException {
        Files.lines(Paths.get("src/prog2/extra/goederen.txt"))
                .map(line -> line.substring(0, 4))
                .forEach(System.out::println);
    }

    private static void tellen() throws IOException {
        System.out.printf("Aantal = %d €\n",
                Files.lines(Paths.get("src/prog2/extra/goederen.txt")).collect(Collectors.counting())
        );
    }

    private static void totalePrijs() throws IOException {
        System.out.printf("Totale prijs = %d €\n",
                Files.lines(Paths.get("src/prog2/extra/goederen.txt"))
                        .map(line -> Integer.parseInt(line.substring(0, 4).trim()))
                        .reduce(0, (p,q) -> p+q)
        );
    }

    private static void totalePrijsBis() throws IOException {
        System.out.printf("Totale prijs = %d €\n",
                Files.lines(Paths.get("src/prog2/extra/goederen.txt"))
                        .mapToInt(line -> Integer.parseInt(line.substring(0, 4).trim()))
                        .sum()
        );
    }

    private static void totalePrijsTer() throws IOException {
        System.out.printf("Totale prijs = %d €\n",
                Files.lines(Paths.get("src/prog2/extra/goederen.txt"))
                        .collect(Collectors.summingInt(line ->  Integer.parseInt(line.substring(0, 4).trim())))
        );
    }

    public static void main(String[] args) throws IOException {
//        allesAfdrukken();
//        tellen();
//        totalePrijs();
        totalePrijsBis();
//        totalePrijsTer();
    }
}
