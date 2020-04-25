/* MailsCompanion.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.mails.v1;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import prog2.mails.xml.Mail;
import prog2.mails.xml.MailsReader;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Partnerklasse voor Mails.fxml
 */
public class MailsCompanion {

    public VBox messages;

    public ChoiceBox<String> choiceBox;

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
        Label message = new Label (mail.getMessage());
        message.setWrapText(true);
        message.getStyleClass().add("message");

        VBox vBox = new VBox(subject, senderPlusDate, message);
        vBox.getStyleClass().add("message-box");
        return vBox;
    }

    /**
     * De lijst van mails die getoond wordt en gesorteerd.
     */
    private List<Mail> list;

    /**
     * Vul het venster (opnieuw) op met de huidige lijst van mails.
     */
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
        this.list = new MailsReader().readMails("/prog2/mails/xml/berichten.xml");
        loadMails();
    }

    /**
     * Sorteer de berichten volgens de manier die is aangegeven in de choicebox.
     */
    public void doSort() {
        // Opgelet, code smell!
        switch (choiceBox.getSelectionModel().getSelectedItem()) {
            case "Onderwerp":
                sortBySubject();
                break;
            case "Tijdstip":
                sortByTime();
                break;
            case "Afzender":
                sortBySender();
                break;
            case "Bericht":
                sortByMessage();
                break;
            default:
                // this cannot happen
                throw new IllegalStateException("Unexpected item selection");
        }
        loadMails();
    }
    
    /*
     * De vier methoden hieronder illustreren elk een verschillende manier om
     * een comparator aan te maken voor het sorteren. In de praktijk zou je dit niet 
     * op die manier doen. Zie ook versie 2 van dit programma.
     * 
     * Er is hier en daar wel wat op te merken op de manier waarop dit is geprogrammeerd - zie les.
     */

    public void sortBySubject() {
        Collections.sort(list, new SubjectComparator());
    }

    public void sortBySender() {
        list.sort(new SenderComparator());
    }

    public void sortByTime() {
        list.sort(new Comparator<Mail>() {
            @Override
            public int compare(Mail o1, Mail o2) {
                return o2.getTime().compareTo(o1.getTime()); // oudste berichten laatst!
            }
        });
    }

    public void sortByMessage() {
        list.sort(
                (o1,o2) -> o1.getMessage().trim().compareTo(o2.getMessage().trim())
        );
    }

    /**
     * Voorbeeld van een binnenklasse.
     */
    public static class SenderComparator implements Comparator<Mail> {

        @Override
        public int compare(Mail mail1, Mail mail2) {
            // we splitsen de voornaam af van de familienaam
            String lastName1 = mail1.getSender();
            int pos1 = lastName1.indexOf(' ');
            String firstName1 = lastName1.substring(0, pos1);
            lastName1 = lastName1.substring(pos1+1);

            String lastName2 = mail2.getSender();
            int pos2 = lastName2.indexOf(' ');
            String firstName2 = lastName2.substring(0, pos2);
            lastName2 = lastName2.substring(pos2+1);

            // eerst sorteren op familienaam dan op voornaam
            int cmp = lastName1.compareTo(lastName2);
            if (cmp == 0) {
                return firstName1.compareTo(firstName2);
            } else {
                return cmp;
            }
        }
    }
}
