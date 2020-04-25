/* MarksInfo.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package Oefeningen.students.databank;

/**
 * Bevat informatie over de punten van één specifiek vak, voor één bepaalde
 * student, met de bedoeling om die te tonen in een tabel.
 */
public class MarksInfo {

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

    private int marks;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    private int studentId;

    /**
     * Identificatie van de student in de databank.
     */
    public int getStudentId() {
        return studentId;
    }

    private int courseId;

    /**
     * Identificatie van de cursus in de databank.
     */
    public int getCourseId() {
        return courseId;
    }

    public MarksInfo(int studentId, int courseId, String lastName, String firstName, int marks) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.marks = marks;
    }
}
