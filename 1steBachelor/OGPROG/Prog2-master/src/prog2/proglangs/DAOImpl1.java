package prog2.proglangs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementatie van {@link DAO} waarbij de voorkeuren in één tabel (prefs) worden opgeslagen.
 */
class DAOImpl1 extends Prog2Database  implements DAO{

    @Override
    public Collection<Preference> getAllPreferences() {
        try (Connection conn = getConnection();
             PreparedStatement stat = conn.prepareStatement(
                     "SELECT name,checked FROM prefs"
             );
             ResultSet rs = stat.executeQuery()
        ){
            Collection<Preference> result = new ArrayList<>();
            while (rs.next()) {
                Preference pref = new Preference();
                pref.name = rs.getString ("name");
                pref.checked = rs.getBoolean("checked");
                result.add (pref);
            }
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException("Cripling database error", ex);
        }
    }

    @Override
    public void updateAllPreferences(Iterable<Preference> prefs) {
        try (Connection conn = getConnection();
             PreparedStatement stat = conn.prepareStatement(
                     "UPDATE prefs SET checked = ? WHERE name = ?"
    )) {
            for (Preference pref : prefs) {
                stat.setBoolean(1, pref.checked);
                stat.setString(2, pref.name);
                stat.addBatch();
            }
            stat.executeBatch();
        } catch (SQLException ex) {
            throw new RuntimeException("Cripling database error", ex);
        }
    }
}
