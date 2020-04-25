package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/*
 * Oplossing voor de mailbox oefening.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Mailbox.main verwacht twee argumenten: invoer uitvoer.");
            System.err.println("Invoer mag zijn: 1. http/s URL, 2. -, 3. bestandsnaam.");
            System.err.println("Uitvoer mag zijn: 1. -, 2. bestandsnaam.");
            System.exit(1);
        } else {
            // Gebruik try-with-resources opdat files automatisch gesloten worden.
            try (BufferedReader reader = getReader(args[0]);
                 PrintWriter writer = getWriter(args[1]))
            {
                converteer(reader, writer);
            } catch (IOException e) {
                System.err.println("Probleem met sluiten van bestand: " + e.getMessage());
            }
        }
    }

    private static BufferedReader getReader(String invoer) {
        InputStream inStream = null;
        if (invoer.startsWith("http://") || invoer.startsWith("https://")) {
            try {
                inStream = new URL(invoer).openStream();
            } catch (MalformedURLException e) {
                System.err.println("Een ongeldige URL opgegeven: " + e.getMessage());
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Kan geen verbinding maken: " + e.getMessage());
                System.exit(1);
            }
        }
        else if (invoer.equals("-")) {
            inStream = System.in;
        }
        else {
            try {
                inStream = Files.newInputStream(new File(invoer).toPath());
            } catch (IOException e) {
                System.err.println("Kan invoerbestand niet openen: " + e.getMessage());
                System.exit(1);
            }
        }
        return new BufferedReader(new InputStreamReader(inStream));
    }

    private static PrintWriter getWriter(String uitvoer) {
        PrintWriter printer = null;
        if (uitvoer.equals("-")) {
            final boolean autoFlush = true;
            printer = new PrintWriter(new OutputStreamWriter(System.out), autoFlush);
        } else {
            try {
                printer = new PrintWriter(
                        Files.newBufferedWriter(new File(uitvoer).toPath(),
                                StandardOpenOption.CREATE,
                                StandardOpenOption.TRUNCATE_EXISTING,
                                StandardOpenOption.WRITE));
            } catch (IOException e) {
                System.err.println("Kan uitvoerbestand niet openen: " + e.getMessage());
                System.exit(1);
            }
        }
        return printer;
    }

    private static void converteer(BufferedReader input, PrintWriter output) {
        output.println("<html><body>");
        try {
            String line;
            while ((line = input.readLine()) != null) {
                if (line.startsWith("From: ") ||
                        line.startsWith("Date: ") ||
                        line.startsWith("Subject: "))
                {
                    int k = line.indexOf(' ');
                    String hdr = line.substring(0, k);
                    String val = line.substring(k);
                    val = val.replaceAll("<", "&lt;");
                    val = val.replaceAll(">", "&gt;");
                    outHeader(hdr, val, output);
                }
                else {
                    outLine(line, output);
                }
            }
        } catch (IOException e) {
            System.err.println("Fout tijdens het lezen van de invoer: " + e.getMessage());
        }
        if (printing_body) {
            output.println("</p>");
        }
        output.println("</body></html>");
    }

    private static boolean printing_body = false;
    private static boolean printing_header = true;

    public static void outHeader(String key, String val, PrintWriter output) {
        if (printing_body) {
            output.println("</p>");
            printing_body = false;
            printing_header = false;
        }
        if (!printing_header) {
            output.println("<hr>");
            printing_header = true;
        }
        output.printf("<strong>%s</strong> %s<br>\n", key, val);
    }

    public static void outLine(String line, PrintWriter output) {
        printing_header = false;
        if (line.isEmpty()) {
            if (printing_body) {
                output.println("</p>");
                printing_body = false;
            }
        }
        else {
            if (!printing_body) {
                output.println("<p>");
                printing_body = true;
            }
            output.println(line);
        }
    }

}