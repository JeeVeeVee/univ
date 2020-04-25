/* TabsCompanion.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.nio;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Initialiseert beide tabs met tekst,
 */
public class TabsCompanion {

    public TextArea textAreaLeft;

    public TextArea textAreaRight;

    // 'Geleend' van ToUpper (maar niet helemaal...)
    private Iterable<String> readAllLines(InputStream in) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(in, Charset.forName("UTF-8")))
        ) {
            List<String> result = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
            return result;
        } catch (IOException e) {
            return null;
        }
    }

    private void showError(TextArea textArea) {
        textArea.setText("<fout: kon bestand niet laden>");
        textArea.getStyleClass().add("error");
    }

    private void fill(TextArea textArea, Iterable<String> lines) {
        for (String line : lines) {
            textArea.appendText(line);
            textArea.appendText("\n");
        }
        textArea.positionCaret(0);
    }


    // http://www.gnu.org/licenses/agpl.txt

    public void initialize() {

        InputStream left = getClass().getResourceAsStream("gedicht.txt");
        if (left == null) {
            showError(textAreaLeft);
        } else {
            fill(textAreaLeft, readAllLines(left));
        }

        try (InputStream right = new URL("http://www.gnu.org/licenses/agpl.txt").openStream()) {
            if (right == null) {
                showError (textAreaRight);
            } else {
                fill(textAreaRight, readAllLines(right));
            }
        } catch (MalformedURLException ex) {
            // this cannot happen
        } catch (IOException ex) {
            showError(textAreaRight);
        }
    }
}
