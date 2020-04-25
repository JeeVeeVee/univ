/* TimeSlot.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.tracker;

import java.time.LocalDateTime;

/**
 * Representeert een gebeurtenis die zich in een bepaalde periode heeft
 * voorgedaan.
 */
public class TimeSlot {

    private LocalDateTime begin;

    /**
     * Beginmoment van deze gebeurtenis.
     */
    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    private LocalDateTime end;

    /**
     * Eindmoment van deze gebeurtenis.
     */
    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    private String description;

    /**
     * Beschrijving van deze gebeurtenis
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeSlot(LocalDateTime begin, LocalDateTime end, String description) {
        this.begin = begin;
        this.end = end;
        this.description = description;
    }

    /**
     * Creeert een nieuw timeslot met de datum van vandaag en een 'leeg' bericht
     */

    public static TimeSlot emptyNow() {
        return new TimeSlot (LocalDateTime.now(), null, "<leeg>");
    }

    public TimeSlot() {
        this.description = "";
    }

    @Override
    public String toString() {
        return "(" + (begin == null ? "???" : begin) + " - " + (end == null ? "???" : end) + ") " + description;
    }
}
