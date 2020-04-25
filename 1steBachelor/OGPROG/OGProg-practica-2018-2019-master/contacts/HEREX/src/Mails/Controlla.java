package Mails;

import Mails.xml.Mail;
import Mails.xml.MailsReader;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Controlla {

    public void doSort() {
        list.sort(
                MAP.get(choiceBox.getSelectionModel().getSelectedItem())
        );
        loadMails();
    }

    public VBox messages;
    public ChoiceBox<String> choiceBox;

    private List<Mail> list;

    private static Map<String, Comparator<Mail>> MAP = Map.of(
            "Onderwerp",
            Comparator.comparing((Mail m) -> {
                String subject = m.getSubject();
                while (subject.startsWith("Re: ")) {
                    subject = subject.substring(4);
                }
                return subject;
            }).thenComparing(m -> m.getSubject().length()),

            "Tijdstip",
            Comparator.comparing(Mail::getTime).reversed(),

            "Afzender",
            Comparator.comparing((Mail m) -> {
                String sender = m.getSender();
                return sender.substring(sender.indexOf(' ') + 1);
            }).thenComparing(Mail::getSender),

            "Bericht",
            Comparator.comparing(m -> m.getMessage().trim())
    );

    /**
     * Component voor één enkel e-mailbericht.
     */
    private Node createMessageNode(Mail mail) {
        // titel
        Label subject = new Label(mail.getSubject());
        subject.getStyleClass().add("subject");

        // tweede lijn
        Label sender = new Label("van: " + mail.getSender());
        sender.getStyleClass().add("sender");


        Label date = new Label(mail.getTime().toString());
        date.getStyleClass().add("date");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox senderPlusDate = new HBox(sender, spacer, date);

        // tekst
        Label message = new Label(mail.getMessage());
        message.setWrapText(true);
        message.getStyleClass().add("message");

        VBox vBox = new VBox(subject, senderPlusDate, message);
        vBox.getStyleClass().add("message-box");
        return vBox;
    }

    public void loadMails() {
        ObservableList<Node> children = messages.getChildren();
        children.clear();
        for (Mail mail : list) {
            children.add(createMessageNode(mail));
        }
    }

    public void initialize() {
        // choicebox
        choiceBox.getItems().addAll(
                "Onderwerp",
                "Tijdstip",
                "Afzender",
                "Bericht"
        );
        choiceBox.getSelectionModel().select(0);

        // berichten
        this.list = new MailsReader().readMails("/Mails/xml/berichten.xml");
        loadMails();
    }
}