package prog2.contacts.jdbc;

import prog2.contacts.DataAccessException;
import prog2.contacts.Person;
import prog2.contacts.PersonFinder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementatie van {@link PersonFinder} voor JDBC. Een object van deze klasse houdt het WHERE-gedeelte
 * bij van de SQL-opdracht en een lijst van strings die uiteindelijk in de prepared statement moeten
 * worden ingevuld.
 * <p>
 * <b>Opmerking</b> De implementatie wordt wel een stuk ingewikkelder als niet alle parameters strings zijn.
 */
class JDBCPersonFinder implements PersonFinder {

    private String whereClause;

    private List<String> parameters;

    private Connection connection;

    private JDBCPersonFinder(Connection connection, String whereClause, List<String> parameters) {
        this.connection = connection;
        this.whereClause = whereClause;
        this.parameters = parameters;
    }

    /**
     * Breidt deze finder uit met één selectie-opdracht en één parameter
     */
    private JDBCPersonFinder extend(String condition, String parameter) {
        if (parameters.isEmpty()) {
            return new JDBCPersonFinder(connection, " WHERE " + condition, Collections.singletonList(parameter));
        } else {
            List<String> copy = new ArrayList<>(parameters);
            copy.add(parameter);
            return new JDBCPersonFinder(
                    connection, whereClause + " AND " + condition, copy
            );
        }
    }


    /**
     * Creëert een finder die alle personen selecteert
     */
    JDBCPersonFinder(Connection connection) {
        this(connection, "", Collections.emptyList());
    }

    @Override
    public PersonFinder whereNameStartsWith(String prefix) {
        return extend("familienaam LIKE (? || '%')", prefix);
    }

    @Override
    public PersonFinder whereFirstNameStartsWith(String prefix) {
        return extend("voornaam LIKE (? || '%')", prefix);
    }

    @Override
    public PersonFinder whereNameContains(String fragment) {
        return extend("familienaam LIKE ('%' || ? || '%')", fragment);
    }

    @Override
    public Iterable<Person> getList() throws DataAccessException {
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT id,voornaam,familienaam FROM personen " + whereClause
        )) {
            // vul parameters in
            int index = 1;
            for (String parameter : parameters) {
                ps.setString(index, parameter);
                index++;
            }

            try (ResultSet rs = ps.executeQuery()) {
                List<Person> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(new Person(
                            rs.getInt("id"),
                            rs.getString("familienaam"),
                            rs.getString("voornaam")));
                }
                return result;
            }
        } catch (SQLException ex) {
            throw new DataAccessException("Could not search for persons.", ex);
        }
    }

    @Override
    public int getCount() throws DataAccessException {
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT count(*) FROM personen " + whereClause
        )) {
            // vul parameters in
            int index = 1;
            for (String parameter : parameters) {
                ps.setString(index, parameter);
                index++;
            }

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new DataAccessException("Unexpected end of result set", null);
                }
            }
        } catch (SQLException ex) {
            throw new DataAccessException("Could not search for persons.", ex);
        }
    }
}
