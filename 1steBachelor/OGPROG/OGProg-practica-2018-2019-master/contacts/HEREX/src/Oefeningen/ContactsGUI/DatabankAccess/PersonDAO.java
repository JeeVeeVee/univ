package Oefeningen.ContactsGUI.DatabankAccess;

public interface PersonDAO {

    int createPerson(Person person) throws Exception;

    void updatePerson(int id, String voornaam, String familienaam) throws Exception;

    void deletePerson(int id) throws Exception;

    Iterable<Person> getPersons(String prefix) throws Exception;
}
