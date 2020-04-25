package prog2.proglangs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Bevat gemeenschappelijke methode voor {@link DAOImpl1} en {@link DAOImpl2}
 */
public class Prog2Database {

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:derby://localhost:45270/prog2", "prog2", "sesamopenu"
        );
    }

}
