/* JDBCContactDAO.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.contacts.jdbc;

import prog2.contacts.Contact;
import prog2.contacts.ContactDAO;
import prog2.contacts.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementatie van {@link ContactDAO} met behulp van JDBC.
 */
class JDBCContactDAO extends JDBCAbstractDAO implements ContactDAO {

    public JDBCContactDAO(Connection connection) {
        super(connection);
    }

    @Override
    public int createContact(int personId, char type, String address) throws DataAccessException {
        try (PreparedStatement ps = prepareAutoGenerated(
                "INSERT INTO contactgegevens(p_id,code,adres) VALUES (?,?,?)"
        )) {
            ps.setInt(1, personId);
            ps.setString(2, Character.toString(type));
            ps.setString(3, address);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                } else {
                    throw new DataAccessException("Could not retreive generated key 'id'.", null);
                }
            }
        } catch (SQLException ex) {
            throw new DataAccessException("Could not create contact.", ex);
        }
    }


    @Override
    public void updateContact(int id, String address) throws DataAccessException {
        try (PreparedStatement ps = prepare(
                "UPDATE contactgegevens SET adres = ? WHERE id = ?")) {
            ps.setString(1, address);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DataAccessException("Could not update contact.", ex);
        }
    }

    @Override
    public void deleteContact(int id) throws DataAccessException {
        try (PreparedStatement ps = prepare(
                "DELETE FROM contactgegevens WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DataAccessException("Could not delete contact.", ex);
        }
    }

    @Override
    public Iterable<Contact> findContacts(int personId) throws DataAccessException {
        try (PreparedStatement ps = prepare(
                "SELECT id,code,adres FROM contactgegevens WHERE p_id = ?")) {
            ps.setInt(1, personId);
            try (ResultSet rs = ps.executeQuery()) {
                List<Contact> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(new Contact(
                            rs.getInt("id"),
                            personId,
                            rs.getString("code").charAt(0),
                            rs.getString("adres")));
                }
                return result;
            }
        } catch (SQLException ex) {
            throw new DataAccessException("Could not obtain contacts.", ex);
        }
    }


    @Override
    public Iterable<Contact> findContactsByType(int personId, char type) throws DataAccessException {
        try (PreparedStatement ps = prepare(
                "SELECT id,adres FROM contactgegevens WHERE p_id = ? AND code = ?")) {
            ps.setInt(1, personId);
            ps.setString(2, Character.toString(type));
            try (ResultSet rs = ps.executeQuery()) {
                List<Contact> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(new Contact(
                            rs.getInt("id"),
                            personId,
                            type,
                            rs.getString("adres")));
                }
                return result;
            }
        } catch (SQLException ex) {
            throw new DataAccessException("Could not obtain contacts.", ex);
        }
    }
}
