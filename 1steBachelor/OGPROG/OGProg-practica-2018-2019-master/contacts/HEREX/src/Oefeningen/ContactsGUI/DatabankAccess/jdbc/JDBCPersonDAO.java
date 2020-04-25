package Oefeningen.ContactsGUI.DatabankAccess.jdbc;

import Oefeningen.ContactsGUI.DatabankAccess.Person;
import Oefeningen.ContactsGUI.DatabankAccess.PersonDAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCPersonDAO extends JDBCAbstractDAO implements PersonDAO {

    public JDBCPersonDAO(Connection connection) {
        super(connection);
    }

    @Override
    public int createPerson(Person person) throws Exception {
        PreparedStatement preparedStatement = super.getConnection().prepareStatement(
                "INSERT INTO personen(familienaam, voornaam) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, person.getFamilienaam());
        preparedStatement.setString(2, person.getVoornaam());
        preparedStatement.executeUpdate();
        int nieuweID;
        try (ResultSet keys = preparedStatement.getGeneratedKeys()){
            if (keys.next()){
                nieuweID = keys.getInt(1);
                System.out.println(nieuweID);
            } else {
                throw new Exception();
            }
        }
        return nieuweID;
    }

    @Override
    public void updatePerson(int id, String name, String firstName) throws Exception {
        try (PreparedStatement ps = prepare(
                "UPDATE personen SET voornaam = ?, familienaam = ? WHERE id = ?")) {
            ps.setString(1, firstName);
            ps.setString(2, name);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Could not update person.", ex);
        }
    }

    @Override
    public void deletePerson(int id) throws Exception {
        PreparedStatement  preparedStatement = super.prepare(
                "delete from personen where id = ?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Iterable<Person> getPersons(String prefix) throws Exception {
        List<Person> output = new ArrayList<>();
        PreparedStatement preparedStatement = prepare(
                "SELECT id,voornaam,familienaam FROM personen " +
                        "WHERE familienaam LIKE (? ||'%') "
        );
        preparedStatement.setString(1, prefix);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Person person = new Person(resultSet.getInt("id"), resultSet.getString("voornaam"), resultSet.getString("familienaam"));
            output.add(person);
        }
        return output;
    }
}
