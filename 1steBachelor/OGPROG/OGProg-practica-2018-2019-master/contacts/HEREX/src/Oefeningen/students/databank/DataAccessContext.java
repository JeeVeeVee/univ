/* DataAccessContext.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package Oefeningen.students.databank;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Implementatie van {@link DataAccessContext} die gebruik maakt van JDBC.
 */
public class DataAccessContext implements AutoCloseable {

    private Connection connection;

    public DataAccessContext(Connection connection) {
        this.connection = connection;
    }

    private MarksInfoDAO markInfoDAO;

    public MarksInfoDAO getMarkInfoDAO() {
        if (markInfoDAO == null) {
            markInfoDAO = new MarksInfoDAO(connection);
        }
        return markInfoDAO;
    }

    private CourseDAO courseDAO;

    public CourseDAO getCourseDAO() {
        if (courseDAO == null) {
            courseDAO = new CourseDAO(connection);
        }
        return courseDAO;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
