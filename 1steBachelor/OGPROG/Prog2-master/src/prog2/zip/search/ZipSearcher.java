/* ZipSearcher.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.zip.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Laat toe om in de databank te zoeken naar een gemeente, op postnummer of naam.
 */
public class ZipSearcher {

    private static final String JDBC_URL = "jdbc:sqlite::resource:zipcodes.sqlite";

    public Iterable<ZipInfo> find (String prefix) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT zip,name FROM town WHERE " +
                    "name LIKE ? || '%' OR " +
                    "zip LIKE ? || '%'")) {
               ps.setString (1, prefix);
               ps.setString (2, prefix);
               try (ResultSet rs = ps.executeQuery()) {
                   List<ZipInfo> result = new ArrayList<> ();
                   while (rs.next()) {
                       result.add (new ZipInfo(
                               rs.getString("zip"),
                               rs.getString("name")));
                   }
                   return result;
               }
        } catch (SQLException ex) {
            throw new RuntimeException ("Zoekopdracht heeft gefaald", ex);
        }
    }


}
