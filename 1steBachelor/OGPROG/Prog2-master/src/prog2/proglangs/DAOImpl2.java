package prog2.proglangs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementatie van {@link DAO} waarbij de voorkeuren in twee tabellen (proglangs en chosen) worden opgeslagen.
 */
class DAOImpl2 extends Prog2Database implements DAO {


    @Override
    public Collection<Preference> getAllPreferences() {

        try (Connection conn = getConnection();
             PreparedStatement stat = conn.prepareStatement(
                     "SELECT proglangs.name, chosen.name AS n FROM " +
                             "proglangs LEFT JOIN chosen USING(name)"
             );
             ResultSet rs = stat.executeQuery()
        ) {
            Collection<Preference> result = new ArrayList<>();
            while (rs.next()) {
                Preference pref = new Preference();
                pref.name = rs.getString("name");
                pref.checked = rs.getString("n") != null;
                result.add(pref);
            }
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException("Cripling database error", ex);
        }
    }

    @Override
    public void updateAllPreferences(Iterable<Preference> prefs) {
        try (Connection conn = getConnection()) {
            // wis alle keuzes
            try (PreparedStatement stat = conn.prepareStatement("DELETE FROM chosen")) {
                stat.executeUpdate();
            }
            try (PreparedStatement stat = conn.prepareStatement(
                    "INSERT INTO chosen(name) VALUES (?)"
            )) {
                for (Preference pref : prefs) {
                    if (pref.checked) {
                        stat.setString(1, pref.name);
                        stat.addBatch();
                    }
                }
                stat.executeBatch();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Cripling database error", ex);
        }
    }
}
