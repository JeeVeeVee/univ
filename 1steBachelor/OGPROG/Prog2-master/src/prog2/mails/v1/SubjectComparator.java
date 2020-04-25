/* SubjectComparator.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */
package prog2.mails.v1;

import prog2.mails.xml.Mail;

import java.util.Comparator;

/**
 * Vergelijkt twee mails aan de hand van hun onderwerp. In principe wordt een 'Re: ' vooraan een
 * onderwerp genegeerd, tenzij voor de rest het onderwerp hetzelfde is.
 */
class SubjectComparator implements Comparator<Mail> {
    @Override
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
}
