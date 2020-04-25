/* MailsCompanion.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.mails.v3;

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

import java.util.List;

/**
 * Partnerklasse voor Mails.fxml
 */
public class MailsCompanion {

    public VBox messages;

    public ChoiceBox<SortChoice> choiceBox;

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
        choiceBox.getItems().addAll( SortChoice.values());
        choiceBox.getSelectionModel().select(0);

        // berichten
        this.list = new MailsReader().readMails("/prog2/mails/xml/berichten.xml");
        loadMails();
    }

    /**
     * Sorteer de berichten volgens de manier die is aangegeven in de choicebox.
     */
    public void doSort() {
        list.sort(
                choiceBox.getSelectionModel().getSelectedItem()
        );
        loadMails();
    }

}
