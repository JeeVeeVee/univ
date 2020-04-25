/* Row.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.students.edit;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Een rij zoals die getoond wordt door de tabel.
 */
public class Row {
    
    /*
     * Gewone, ttz., boon-eigenschappen. 
     */

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    private int courseId;

    public int getCourseId() {
        return courseId;
    }
    
    /*
     * JavaFX-eigenschappen
     */

    private final IntegerProperty originalMarks = new SimpleIntegerProperty();

    public int getOriginalMarks() {
        return originalMarks.get();
    }

    public void setOriginalMarks(int value) {
        originalMarks.set(value);
    }

    public IntegerProperty originalMarksProperty() {
        return originalMarks;
    }

    private final IntegerProperty marks = new SimpleIntegerProperty();

    public int getMarks() {
        return marks.get();
    }

    public void setMarks(int value) {
        marks.set(value);
    }

    public IntegerProperty marksProperty() {
        return marks;
    }

    private BooleanProperty changed = new SimpleBooleanProperty();

    public boolean isChanged() {
        return changed.get();
    }

    public void setChanged(boolean value) {
        changed.set(value);
    }

    public BooleanProperty changedProperty() {
        return changed;
    }


    
}
