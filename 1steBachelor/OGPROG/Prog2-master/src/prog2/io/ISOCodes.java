/* Copyright © 2016 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */
package prog2.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Laat toe om de naam van een land op te vragen aan de hand van zijn tweeletterige ISO-code.
 */
public class ISOCodes {


    private static final Map<String, String> NAMES = new HashMap<>();

    private static void readNames(BufferedReader reader, Map<String,String> map) throws IOException {
        String line = reader.readLine();
        while (line != null) {
            int pos = line.lastIndexOf(';');
            map.put(
                    line.substring(pos+1),
                    line.substring(0, pos)
            );
            line = reader.readLine();
        }
    }

    static {
        // Leest de codes in vanuit het classpath
        try {
            readNames(
                new BufferedReader(new InputStreamReader(ISOCodes.class.getResourceAsStream("isocodes.txt"))),
                NAMES
            );
        } catch (IOException ex) {
            throw new RuntimeException("Kon de ISO-codes niet initializeren", ex);
        }
    }

    public static String getNameForCode(String code) {
        return NAMES.get(code);
    }

    public static void main(String[] args) {
        System.out.println (ISOCodes.getNameForCode("BE"));
        System.out.println (ISOCodes.getNameForCode("FR"));
        System.out.println (ISOCodes.getNameForCode("NL"));
        System.out.println (ISOCodes.getNameForCode("AF"));
        System.out.println (ISOCodes.getNameForCode("AX"));
        System.out.println (ISOCodes.getNameForCode("ZW"));
    }
}
