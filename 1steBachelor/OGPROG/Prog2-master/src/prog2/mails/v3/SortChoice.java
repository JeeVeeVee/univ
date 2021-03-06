/* SortChoice.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */
package prog2.mails.v3;

import prog2.mails.xml.Mail;

import java.util.Comparator;

/**
 * Klasse die alle comparatormethoden verzamelt in één plaats.
 */
public enum SortChoice implements Comparator<Mail> {

    BY_SUBJECT("Onderwerp") {
        public int compare(Mail mail1, Mail mail2) {
            //
            String subject1 = mail1.getSubject();
            while (subject1.startsWith("Re: ")) {
                subject1 = subject1.substring(4);
            }

            String subject2 = mail2.getSubject();
            while (subject2.startsWith("Re: ")) {
                subject2 = subject2.substring(4);
            }

            int cmp = subject1.compareTo(subject2);
            if (cmp == 0) {
                return mail1.getSubject().length() - mail2.getSubject().length();
            } else {
                return cmp;
            }
        }
    },

    BY_SENDER("Afzender") {
        public int compare(Mail mail1, Mail mail2) {
            // we splitsen de voornaam af van de familienaam
            String lastName1 = mail1.getSender();
            int pos1 = lastName1.indexOf(' ');
            String firstName1 = lastName1.substring(0, pos1);
            lastName1 = lastName1.substring(pos1 + 1);

            String lastName2 = mail2.getSender();
            int pos2 = lastName2.indexOf(' ');
            String firstName2 = lastName2.substring(0, pos2);
            lastName2 = lastName2.substring(pos2 + 1);

            // eerst sorteren op familienaam dan op voornaam
            int cmp = lastName1.compareTo(lastName2);
            if (cmp == 0) {
                return firstName1.compareTo(firstName2);
            } else {
                return cmp;
            }
        }
    },

    BY_TIME("Tijdstip") {
        public int compare(Mail o1, Mail o2) {
            return o2.getTime().compareTo(o1.getTime()); // oudste berichten laatst!
        }
    },

    BY_MESSAGE("Bericht") {
        public int compare(Mail o1, Mail o2) {
            return o1.getMessage().trim().compareTo(o2.getMessage().trim());
        }
    };

    private final String description;

    @Override
    public String toString() {
        return description;
    }

    SortChoice(String description) {
        this.description = description;
    }
}
