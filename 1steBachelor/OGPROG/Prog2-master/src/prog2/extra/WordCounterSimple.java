package prog2.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Houdt bij van elk woord hoeveel keer het voorkomt. Dit is
 * een eenvoudige versie die geen gebruik maakt van enkele
 * nieuwigheden uit Java 8.
 */
public class WordCounterSimple {

    private Map<String, Integer> map;

    public WordCounterSimple() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        if (map.containsKey(word)) {
            map.put(word, map.get(word) + 1);
        } else {
            map.put(word, 1);
        }
    }

    public static String cleaned (String word) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                buffer.append( Character.toLowerCase(ch));
            } else {
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    /**
     * Add all words that occur in the given line. First the
     * line is cleaned (nonalphabetic characters are replaced
     * by spaces) and then it is split into words.
     */
    public void processLine(String line) {
        String[] words = cleaned(line).split("\\h+"); // split on white spaces
        for (String word : words) {
            addWord(word);
        }
    }

    /**
     * All recorded entries, as a set.
     */
    public Set<Map.Entry<String,Integer>> getEntrySet() {
        return map.entrySet();
    }

    public static void main(String[] args) throws IOException {
        WordCounterSimple wc = new WordCounterSimple();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        WordCounterSimple.class.getResourceAsStream("tekst.txt"),
                        Charset.defaultCharset()
                ))) {
            String line = reader.readLine();
            while (line != null) {
                wc.processLine(line);
                line = reader.readLine();
            }
        }

        List<Map.Entry<String, Integer>> result =
                new ArrayList<>(wc.getEntrySet());
        result.sort(
                (e, f) -> f.getValue().compareTo(e.getValue() )
                );

        for (Map.Entry<String, Integer> entry : result) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
