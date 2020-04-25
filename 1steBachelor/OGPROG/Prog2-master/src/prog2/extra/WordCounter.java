package prog2.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Houdt bij van elk woord hoeveel keer het voorkomt.
 */
public class WordCounter {

    private Map<String, Integer> map;

    public WordCounter() {
        map = new HashMap<>();
    }

    public void addWordAlt(String word) {
        map.put(word,
                map.computeIfAbsent(word, k -> 0) + 1
        );
    }

    // alternatief dat in dit geval wellicht beter is (maar geen lambda gebruikt)

    public void addWord(String word) {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    /**
     * Add all words that occur in the given line. First the
     * line is cleaned (nonalphabetic characters are replaced
     * by spaces) and then it is split into words.
     */
    public void processLine(String line) {
        String[] words = WordCounterSimple.cleaned(line).split("\\h+"); // split on white spaces
        for (String word : words) {
            addWord(word);
        }
    }

    /**
     * All recorded entries, as a set.
     */
    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return map.entrySet();
    }

    public static void main(String[] args) throws IOException {
        WordCounter wc = new WordCounter();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        WordCounter.class.getResourceAsStream("tekst.txt"),
                        Charset.defaultCharset()
                ))) {
            reader.lines().forEach(wc::processLine);
        }

        wc.getEntrySet().stream().sorted(
                (e, f) -> f.getValue().compareTo(e.getValue())
        ).forEach(
                e -> System.out.println(e.getKey() + ": " + e.getValue())
        );
    }
}
