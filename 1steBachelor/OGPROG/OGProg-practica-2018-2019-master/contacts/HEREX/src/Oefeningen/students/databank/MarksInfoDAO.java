/* MarksInfoDAO.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package Oefeningen.students.databank;

import Oefeningen.students.databank.MarksInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object waarmee informatie over punten kan worden opgehaald.
 */
public class MarksInfoDAO {

    protected Connection connection;

    public MarksInfoDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Alle punten van alle studenten voor een bepaalde cursus.
     */
    public Iterable<MarksInfo> listMarks(int courseId) throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT student_id, course_id,last_name, first_name, value "
                + "FROM student,mark WHERE student_id=id AND course_id = ? "
                + "ORDER BY last_name, first_name")) {
            ps.setInt(1, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                List<MarksInfo> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(new MarksInfo(
                            rs.getInt("student_id"),
                            rs.getInt("course_id"),
                            rs.getString("last_name"),
                            rs.getString("first_name"),
                            rs.getInt("value")));
                }
                return result;
            }
        }
    }

    /**
     * Pas de punten aan voor een bepaalde student en een bepaalde cursus
     */
    public void updatePoints(int studentId, int courseId, int newMarks) throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE mark SET value=? WHERE student_id = ? AND course_id = ?")) {
            ps.setInt(1, newMarks);
            ps.setInt (2, studentId);
            ps.setInt (3, courseId);
            ps.execute();
        }
    }
}
