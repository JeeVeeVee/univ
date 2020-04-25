/* CourseDAO.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package Oefeningen.students.databank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data access object waarmee informatie over een vak kan worden opgehaald.
 */
public class CourseDAO {

    protected Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    public String getCourseTitle(int courseId) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT title FROM course WHERE id = ?") ) {
            ps.setInt(1, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("title");
                } else {
                    return null;
                }
            }
        }
    }
    
}
