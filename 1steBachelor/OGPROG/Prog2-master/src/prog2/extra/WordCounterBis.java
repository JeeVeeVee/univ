package prog2.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Drukt af van elk woord hoeveel keer het voorkomt. Gebruikt *meer* streams
 */
public final class WordCounterBis {

    private static Stream<String> split(String line) {
        return Arrays.stream(
                line.split("\\h+")
        );
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        WordCounterBis.class.getResourceAsStream("tekst.txt"),
                        Charset.defaultCharset()
                ))) {
            reader.lines()
                    .map(WordCounterSimple::cleaned)
                    .flatMap(WordCounterBis::split)
                    .filter(w -> !w.isEmpty())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .forEach((k, v) -> System.out.println(k + ": " + v)); // niet gesorteerd in dit geval
        }
    }
}
