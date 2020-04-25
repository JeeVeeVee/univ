package prog2.mails.xml;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Leest het berichtenbestand in en converteert dit naar een lijst van Mail-objecten.
 */
public class MailsReader {

    public List<Mail> readMails(String resource){
        try {
            return new SAXBuilder().build(getClass().getResource(resource))
                    .getRootElement().getChildren("mail").stream()
                    .map(el -> new Mail(
                            el.getChild("subject").getTextNormalize(),
                            el.getChild("sender").getTextNormalize(),
                            el.getChild("message").getTextTrim(),
                            LocalDateTime.parse(el.getChild("time").getTextNormalize())
                    )).collect(Collectors.toList());
        } catch (IOException | JDOMException ex) {
            throw new RuntimeException("Could not read or find resource: " + resource, ex);
        }
    }
}
